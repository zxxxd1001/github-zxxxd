package com.git.zxxxd.guice.demo.spring.hello.dao;

import org.springframework.stereotype.Component;

@Component
public class HelloDao {
    public  void save(String str){
        System.out.println(str+" saved.");
    }
}
