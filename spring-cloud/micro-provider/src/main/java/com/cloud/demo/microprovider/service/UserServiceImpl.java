package com.cloud.demo.microprovider.service;

import com.cloud.demo.microprovider.domain.UserInfo;
import com.cloud.demo.microprovider.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tuganglei
 * @date 2018/10/30 14:11
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userMapper;

    @Override
    public UserInfo getUserById(Integer userId){
        return userMapper.getUser(userId);
    }
}
