package com.boot.enable.imp;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author tuganglei
 * @date 2018/10/22 16:13
 */
public class MyBeanDefinition implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        BeanDefinition beanDefinition = bdb.getBeanDefinition();
        registry.registerBeanDefinition("user",beanDefinition);
    }
}
