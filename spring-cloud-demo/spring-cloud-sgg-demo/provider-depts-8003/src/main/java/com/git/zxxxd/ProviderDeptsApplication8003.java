package com.git.zxxxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(value = "com.git.zxxxd.dao")
@SpringBootApplication
//本服务启动后会自动注册进eureka服务
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderDeptsApplication8003 {
    public static void main(String[] args) {
            SpringApplication.run(ProviderDeptsApplication8003.class,args);
    }
}
