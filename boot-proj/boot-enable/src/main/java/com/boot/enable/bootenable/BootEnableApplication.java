package com.boot.enable.bootenable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootEnableApplication.class, args);
        RunnableDemo bean = context.getBean(RunnableDemo.class);
        System.out.println("---------begin-------------");
        bean.run();
        System.out.println("-------end-----------------");
        context.close();
    }
}
