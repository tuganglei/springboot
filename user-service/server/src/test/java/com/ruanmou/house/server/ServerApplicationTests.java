package com.ruanmou.house.server;

import com.ruanmou.house.server.user.domain.User;
import com.ruanmou.house.server.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = userService.getUserById(11L);
        // 断言
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetUserByCondition() throws Exception {
//        User user = new User();
//        user.setEmail("spring_boot@163.com");
//        user.setPassword(HashUtils.encryPassword("123456"));
//        List<User> list = userService.getUserByCondition(user);
//        // 断言
//        Assert.assertNotNull(list.get(0));
    }

    @Test
    public void testAddAccount() throws Exception {
        // 创建一个用户
        User user = new User();
        user.setPassword("123456");
        user.setEmail("1409345189@qq.com");
        user.setAvatar("/1493439911/client-01.jpg");
        user.setAboutme("geee");
        user.setEnable(0);
        user.setName("luomu");
        user.setPhone("15101070601");
        user.setType(1);
        userService.addAccount(user, "http://192.168.1.190:8081/user/enable");
    }

    @Test
    public void testEnableAccount() throws Exception {
        userService.enableAccount("f22e29e150f4b6d624a9d177e2bb07adSOCtCkRjvq");
    }

}
