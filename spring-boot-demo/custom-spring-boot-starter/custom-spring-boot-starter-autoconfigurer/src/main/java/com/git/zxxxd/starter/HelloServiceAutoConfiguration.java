package com.git.zxxxd.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication//web应用才生效
@EnableConfigurationProperties(SayHelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    private SayHelloProperties helloProperties;

    @Bean
    public SayHelloService helloService(){
        SayHelloService helloService=new SayHelloService();
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }

}
