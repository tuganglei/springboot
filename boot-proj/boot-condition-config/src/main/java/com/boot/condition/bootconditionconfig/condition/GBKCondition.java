package com.boot.condition.bootconditionconfig.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author tuganglei
 * @date 2018/10/18 17:38
 */
public class GBKCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = System.getProperty("file.encoding");
        if("gbk".equalsIgnoreCase(encoding)){
            return true;
        }
        return false;
    }
}
