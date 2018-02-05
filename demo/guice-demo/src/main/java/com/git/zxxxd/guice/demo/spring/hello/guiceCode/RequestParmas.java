package com.git.zxxxd.guice.demo.spring.hello.guiceCode;

import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class RequestParmas {
    public RequestParmas() {
        System.out.println("RequestParmas");
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
