package com.boot.config.core.configcore1;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tuganglei
 * @date 2018/10/23 14:56
 */

@Configuration
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DatasourceProperties datasourceProperties(){
        return new DatasourceProperties();
    }

}
