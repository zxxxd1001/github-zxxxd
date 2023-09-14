package com.git.zxxxd.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("BeanDefinitionMap填充完毕后回调该方法，MyBeanDefinitionRegistryPostProcessor执行了==postProcessBeanDefinitionRegistry==...");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanDefinitionMap填充完毕后回调该方法，MyBeanDefinitionRegistryPostProcessor执行了==postProcessBeanFactory==...");
    }
}
