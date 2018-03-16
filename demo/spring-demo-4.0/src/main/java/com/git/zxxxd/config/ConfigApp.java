package com.git.zxxxd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ConfigApp {
    /**
     * @Bean 注释用于定义 bean。
     *  上述注释位于实例化 bean 并设置依赖项的方法上方。
     *  方法名称与 bean id 或默认名称相同。
     * @return  该方法的返回类型是向 Spring 应用程序上下文注册的 bean
     */
    @Bean
    public Date getDate(){
        return new Date();
    }
}
