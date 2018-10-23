package com.boot.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tuganglei
 * @date 2018/10/18 16:20
 */

@Configuration
public class UserConfig {

    @Bean("user")
    public User createUser(){
        return new User();
    }
}
