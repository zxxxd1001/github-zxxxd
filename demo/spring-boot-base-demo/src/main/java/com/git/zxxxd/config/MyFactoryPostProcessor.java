package com.git.zxxxd.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * BeanFactory是DefaultListableBeanFactory 是 ConfigurableListableBeanFactory 的实现类
     * 自然就可以对 beanDefinitionMap 中的 BeanDefinition 进行操作了 ，例如对 UserDaoImpl 的 BeanDefinition 进行修改操作
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionMap填充完毕后回调该方法，MyBeanFactoryPostProcessor执行了...");
        // userDao初始的bean的定义<bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"/>，类型为UserDaoImpl
//        BeanDefinition userDaoBD = beanFactory.getBeanDefinition("userDao");//获得UserDao定义对象
        // 修改userDao的类型为UserDaoImpl2
//        userDaoBD.setBeanClassName("com.itheima.dao.impl.UserDaoImpl2"); //修改class
        // userDaoBD.setInitMethodName(methodName); //修改初始化方法
        // userDaoBD.setLazyInit(true); //修改是否懒加载
        // ... 省略其他的设置方式 ...
    }
}