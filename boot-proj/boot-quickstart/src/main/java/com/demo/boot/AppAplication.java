package com.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */


public class AppAplication
{
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

    }

}
