package com.git.zxxxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class SuccessController {
    @RequestMapping("success")
    public String successHello(Map<String,Object> map){
        map.put("hello","world");
        //classpath:/templates
        return "success";
    }
    @RequestMapping("testError")
    public String testError(){
        int i=new Integer(null);
        return "success";
    }
}
