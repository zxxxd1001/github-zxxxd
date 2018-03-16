package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@SpringBootApplication
//@PropertySource("classpath:application.yml")
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class,args);
    }
}
