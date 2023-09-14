package com.git.zxxxd.config;

import com.git.zxxxd.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelect implements DeferredImportSelector {
    @Autowired
    private TestController testController;
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{MyConfig.class.getName()};
    }
}
