package com.boot.enable.imp;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author tuganglei
 * @date 2018/10/22 16:02
 */
public class ImportUser implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.boot.enable.imp.User"};
    }
}
