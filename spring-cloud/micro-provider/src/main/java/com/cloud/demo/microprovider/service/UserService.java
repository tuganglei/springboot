package com.cloud.demo.microprovider.service;

import com.cloud.demo.microprovider.domain.UserInfo;

/**
 * @author tuganglei
 * @date 2018/10/30 14:14
 */
public interface UserService {

    public UserInfo getUserById(Integer userId);
}
