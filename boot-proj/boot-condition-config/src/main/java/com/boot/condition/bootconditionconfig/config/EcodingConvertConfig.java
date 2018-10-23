package com.boot.condition.bootconditionconfig.config;

import com.boot.condition.bootconditionconfig.condition.GBKCondition;
import com.boot.condition.bootconditionconfig.condition.UTF8Condition;
import com.boot.condition.bootconditionconfig.convert.GBKEcodingConvert;
import com.boot.condition.bootconditionconfig.convert.UTF8EcodingConvert;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @author tuganglei
 * @date 2018/10/18 17:26
 */

@SpringBootConfiguration
public class EcodingConvertConfig {

    @Bean
    @Conditional(UTF8Condition.class)
    public UTF8EcodingConvert createUTF8(){
        return new UTF8EcodingConvert();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public GBKEcodingConvert createGBK(){
        return new GBKEcodingConvert();
    }
}
