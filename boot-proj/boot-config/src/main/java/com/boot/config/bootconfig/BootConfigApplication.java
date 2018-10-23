package com.boot.config.bootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class BootConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootConfigApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();
        String property = env.getProperty("local.ip.addr");
        String currentDir = env.getProperty("user.dir");
        String localName = env.getProperty("local.name");
        System.out.println(property);
        System.out.println(currentDir);
        System.out.println(localName);
        RedisConfig redisConfig = context.getBean(RedisConfig.class);
        redisConfig.show();

        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource);

        context.close();
    }
}
