package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReaderCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReaderCloudConfigApplication.class,args);
    }
}
