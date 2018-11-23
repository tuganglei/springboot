package com.ruanmou.house.server.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.ruanmou.house.server.user.constant.UserEnum;
import com.ruanmou.house.server.user.domain.User;
import com.ruanmou.house.server.user.exception.UserException;
import com.ruanmou.house.server.user.mapper.UserMapper;
import com.ruanmou.house.server.user.service.MailService;
import com.ruanmou.house.server.user.service.UserService;
import com.ruanmou.house.utils.BeanHelper;
import com.ruanmou.house.utils.HashUtils;
import com.ruanmou.house.utils.JwtHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: user-service
 * @Auther: GERRY
 * @Date: 2018/11/13 21:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    // 单个用户的前缀
    private static final String USER_KEY_PREFIX = "user:";

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private MailService mailService;

    @Value("${image.file.server}")
    private String imagePrefix;

    /**
     * 思路：
     * 1、根据key获取缓存中的存储对象
     * 2、判断是否在缓存中存储，如果存在直接返回，如果不存在，从数据库中获取数据并存储到缓存
     * 3、设置key的过期时间
     *
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        String userKey = USER_KEY_PREFIX + id;
        User user = (User) redisTemplate.opsForValue().get(userKey);
        if (user == null) {
            user = userMapper.selectByPrimaryKey(id);
            // 保存到redis中
            redisTemplate.opsForValue().set(userKey, user);
            // 设置过期时间
            redisTemplate.expire(userKey, 5, TimeUnit.MINUTES);
        }

        return user;
    }

    /**
     * 根据用户的条件查询用户信息列表
     *
     * @param user
     * @return
     */
    public List<User> getUserByCondition(User user) {
        List<User> users = userMapper.select(user);
        users.forEach(u -> u.setAvatar(imagePrefix + u.getAvatar()));
        return users;
    }

    @Override
    public boolean addAccount(User user, String enableUrl) {
        // 使用md5对密码加密
        user.setPassword(HashUtils.encryPassword(user.getPassword()));
        BeanHelper.onInsert(user);
        userMapper.insert(user);
        // 发送邮件验证
        registerNotify(user.getEmail(), enableUrl);
        return true;
    }

    // 通过邮箱发送的key激活账户
    public boolean enableAccount(String key) {
        String email = (String) redisTemplate.opsForValue().get(key);
        if (email == null) {
            throw new RuntimeException("邮件不合法，key无效");
        }
        User user = new User();
        user.setEmail(email);
        user.setEnable(1);
        userMapper.updateUser(user);
        return true;
    }

    @Override
    public User login(String email, String password) {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            throw new UserException(UserException.UserType.ACCOUNT_AND_PASSWORD_IS_NULL, "账号密码必须");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setEnable(UserEnum.ACTIVE.getCode());
        List<User> userList = getUserByCondition(user);
        if (!userList.isEmpty()) {
            User returnUser = userList.get(0);
            onLogin(returnUser);
            return returnUser;
        }
        throw new UserException(UserException.UserType.USER_AUTH_FAIL, "用户登录失败");
    }

    //生成token
    private void onLogin(User returnUser) {
        String token = JwtHelper.genToken(ImmutableMap.of("name", returnUser.getName(), "email", returnUser.getEmail(), "ts", Instant.now().getEpochSecond() + ""));
        String newToken = resetToken(token,returnUser.getEmail());
        returnUser.setToken(newToken);
    }

    @Override
    public User getLoginUserByToken(String token) {
        Map<String,String> map = null;
        try {
        map = JwtHelper.verifyToken(token);
        }catch (Exception e){
           throw  new UserException(UserException.UserType.USER_NOT_LOGIN,"TOKEN失效，请重新登录");
        }
        String email = map.get("email");
        //判断token是否失效
        Long expire = redisTemplate.getExpire(email);
        if( expire > 0L ){
            User user = getUserByEmail(email);
            String newToken = resetToken(token,user.getEmail());
            user.setToken(newToken);
            return user;
        }
            throw  new UserException(UserException.UserType.USER_NOT_LOGIN,"TOKEN失效，请重新登录");

    }

    private User getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        List<User> userList = getUserByCondition(user);
        if(!userList.isEmpty()){
            return userList.get(0);
        }
        throw new UserException(UserException.UserType.USER_NOT_FOUNT,"该用户不存在");
    }

    @Override
    public void logout(String token) {
        Map<String, String> map = JwtHelper.verifyToken(token);
        redisTemplate.delete(map.get("email"));

    }

    // 发送邮箱验证
    private void registerNotify(String email, String enableUrl) {
        // 邮件激活的key
        String randomKey = HashUtils.hashString(email) + RandomStringUtils.randomAlphabetic(10);
        // 把验证key与邮件绑定
        redisTemplate.opsForValue().set(randomKey, email);
        // 设置过期时间
        redisTemplate.expire(randomKey, 30, TimeUnit.MINUTES);
        // 生成激活地址
        String content = enableUrl + "?key=" + randomKey;
        // 发送激活邮件
        mailService.sendMail("房产平台注册激活邮件", content, email);
    }

    //定义重置token
    public String resetToken(String token,String email){
        redisTemplate.opsForValue().set(email,token);
        redisTemplate.expire(email,30,TimeUnit.MINUTES);
        return token;
    }


}
