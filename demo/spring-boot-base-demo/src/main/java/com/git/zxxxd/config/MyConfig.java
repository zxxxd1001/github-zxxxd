package com.git.zxxxd.config;

import com.git.zxxxd.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyConfig implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition("com.git.zxxxd.config.MyPostProcessor")) {
            registry.registerBeanDefinition("com.git.zxxxd.config.MyPostProcessor", new RootBeanDefinition(MyPostProcessor.class));
        }
        if (!registry.containsBeanDefinition("com.git.zxxxd.config.MyAware")) {
            registry.registerBeanDefinition("com.git.zxxxd.config.MyAware", new RootBeanDefinition(MyAware.class));
        }
    }
}
