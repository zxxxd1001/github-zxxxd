package com.git.zxxxd.server.aop;

public class Hello {
    @Log
    public String print(String str){
        return str;
    }

    public String test(String str){
        System.out.println("test");
        return str;
    }

    @Log
    public String add(String str,LogInterceptor interceptor){
        System.out.println("aop结束后才回调用方法体内容");
        return str;
    }
}
