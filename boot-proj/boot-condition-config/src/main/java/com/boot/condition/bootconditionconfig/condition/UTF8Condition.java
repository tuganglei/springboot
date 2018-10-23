package com.boot.condition.bootconditionconfig.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author tuganglei
 * @date 2018/10/18 17:38
 */
public class UTF8Condition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        if("utf-8".equalsIgnoreCase(encoding)){
            return true;
        }
        return false;
    }
}
