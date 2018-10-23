package com.boot.enable.sample;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * @author tuganglei
 * @date 2018/10/22 16:42
 */
public class ScannerPackageRegistrar implements ImportBeanDefinitionRegistrar{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String[] attrs = (String[]) importingClassMetadata.getAnnotationAttributes(EnableScanner.class.getName()).get("packages");
        List<String> strings = Arrays.asList(attrs);
        System.out.println(strings);

        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(MyBeanDefinitionProcessor.class);
        bdb.addPropertyValue("packages", strings);
        registry.registerBeanDefinition(MyBeanDefinitionProcessor.class.getName(),bdb.getBeanDefinition());
    }
}
