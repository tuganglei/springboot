package com.boot.enable.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author tuganglei
 * @date 2018/10/22 16:54
 */
public class MyBeanDefinitionProcessor implements BeanPostProcessor {

    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for(String pack:packages){
            if(bean.getClass().getName().startsWith(pack)){
                System.out.println("instances bean="+bean.getClass().getName());
            }
        }
        return null;
    }
}
