package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Logger logger=LoggerFactory.getLogger(HelloController.class);
    @PostMapping("/hello")
    public Department testJsonXss(@RequestBody Department department){
        logger.info("Department====>",department);
        return department;
    }

    @PostMapping("/form")
    public Department testformXss(Department department){
        logger.info("Department====>",department);
        return department;
    }
    @GetMapping("/get")
    public String testGetXss(String department){
        logger.info(department);
        return department;
    }
}
