package com.git.zxxxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan(value = "com.git.zxxxd.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ProviderDeptsHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptsHystrixApplication.class,args);
    }
}
