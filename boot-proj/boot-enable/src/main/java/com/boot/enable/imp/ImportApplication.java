package com.boot.enable.imp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * @author tuganglei
 * @date 2018/10/22 15:49
 */
@SpringBootApplication
@Import(MyBeanDefinition.class)
public class ImportApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportApplication.class, args);
        User user = context.getBean(User.class);
        Book book = context.getBean(Book.class);
        System.out.println(user);
        System.out.println(book);
        context.close();
    }


}
