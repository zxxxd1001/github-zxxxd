package com.git.zxxxd.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    没有自适应效果...
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Map<String,Object> testException(Exception e){
//        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("message","错误处理信息");
//        return map;
//    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        //转发到/error
        return "forward:/error";
    }
}
