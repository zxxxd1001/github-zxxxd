package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/**
 * 启用eureka服务,接收其他服务注册
 */
@EnableEurekaServer
public class SpringCloudEurakaApplication7003 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurakaApplication7003.class,args);
    }
}
