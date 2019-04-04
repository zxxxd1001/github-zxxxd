package com.git.zxxxd.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.git.zxxxd.entity.Data;
import com.git.zxxxd.entity.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestParameterController {

    @RequestMapping("/{patch}/testOne")
    public String testOne(HttpServletRequest request,
                          @RequestParam("hello") String hl,
                          String world,
                          @PathVariable("patch") String pathName){
        String h=request.getParameter("hello");
        String w=request.getParameter("world");
        System.out.println(pathName);
        System.out.println(h+","+w);
        return hl+","+world+" : "+pathName;
    }
    @RequestMapping("/testTwo")
    public ResultData testTwo(ResultData data,HttpServletRequest request){
        return data;
    }
    @RequestMapping(value = "/testList")
    public List testList(@RequestBody List<Object> data, HttpServletRequest request){
        System.out.println();
        return data;
    }
    @RequestMapping("/testBody")
    public ResultData testThree(@RequestBody ResultData data, HttpServletRequest request){
        data.setData("Sas");
        return data;
    }

    @PostMapping("/testThree")
    public Data testThree(@RequestBody Data data,HttpServletRequest request){
        data.setUser("server");
        return data;
    }
    @RequestMapping("/testMap")
    public Map testMap(@RequestBody Map data,HttpServletRequest request){
        return data;
    }
    @RequestMapping("/testDateTimeParam")
    public Date testDateTimeParam(Date date){
        return date;
    }
    @RequestMapping("/testDateParam")
    public Date testDateParam(Date date){
        return date;
    }
}
