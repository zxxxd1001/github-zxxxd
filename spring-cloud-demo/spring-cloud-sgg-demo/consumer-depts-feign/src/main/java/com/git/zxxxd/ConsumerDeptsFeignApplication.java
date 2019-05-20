package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务式是能去加载我们定义的Feign配置类
 */
@EnableFeignClients(basePackages = "com.git.zxxxd")
public class ConsumerDeptsFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptsFeignApplication.class, args);
    }
}
