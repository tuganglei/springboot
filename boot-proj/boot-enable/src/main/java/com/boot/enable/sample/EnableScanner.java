package com.boot.enable.sample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author tuganglei
 * @date 2018/10/22 16:39
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ScannerPackageRegistrar.class)
public @interface EnableScanner {
    String[] packages();
}
