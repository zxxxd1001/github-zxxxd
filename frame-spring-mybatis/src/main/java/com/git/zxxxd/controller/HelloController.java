package com.git.zxxxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @GetMapping("/hello.do")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response){
        return "Hello,World!";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        Integer i=null;
        int y=i;
        return "test";
    }
}
