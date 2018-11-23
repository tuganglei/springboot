package com.ruanmou.house.server.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: user-service
 * @Auther: GERRY
 * @Date: 2018/11/13 16:14
 * @Description:
 */
@Controller
@RequestMapping("accounts")
public class UserController {

    /**
     * 到登录页面
     */
    @GetMapping("signin")
    public String signin() {
        return "accounts/signin";
    }

    /**
     * 注解界面
     */
    @GetMapping("register")
    public String register() {
        return "accounts/register";
    }

    /**
     * 记住密码
     */
    @GetMapping("remember")
    public String remember() {
        return "accounts/remember";
    }
}
