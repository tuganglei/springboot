package com.boot.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.boot.spring");
        User bean = context.getBean("user",User.class);
        User bean1 = context.getBean("user",User.class);
        UserConfig bean2 = context.getBean(UserConfig.class);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);
        context.close();
    }
}
