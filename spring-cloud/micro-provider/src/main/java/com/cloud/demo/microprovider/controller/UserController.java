package com.cloud.demo.microprovider.controller;

import com.cloud.demo.microprovider.domain.UserInfo;
import com.cloud.demo.microprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuganglei
 * @date 2018/10/30 14:16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public UserInfo getUser(@PathVariable("id")Integer userId){
        return userService.getUserById(userId);
    }
}
