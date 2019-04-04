package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 *  @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 *  @ImportResource 导入spring xml 配置文件
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class,args);
    }
}
