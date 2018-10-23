package com.boot.config.core.config;

import com.boot.config.core.domain.Order;
import com.boot.config.core.domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tuganglei
 * @date 2018/10/23 14:35
 */

@Configuration
public class BeanConfigration {

    @Bean
    public Order createOrder(){
        return new Order();
    }

    @Bean
    public Product createProduct(){
        return new Product();
    }

}
