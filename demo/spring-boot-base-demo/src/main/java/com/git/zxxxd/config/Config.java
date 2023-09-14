package com.git.zxxxd.config;

import com.git.zxxxd.bean.Dog;
import com.git.zxxxd.bean.Food;
import com.git.zxxxd.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class Config implements WebMvcConfigurer {
//public class Config extends WebMvcConfigurationSupport {



//    @Bean(initMethod = "myInitMethod")
//    public Dog dog(){
//        Dog dog = new Dog();
//        return dog;
//    }
//    @Bean
//    public Food food(){
//        Food food = new Food();
//        return food;
//    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }
}
