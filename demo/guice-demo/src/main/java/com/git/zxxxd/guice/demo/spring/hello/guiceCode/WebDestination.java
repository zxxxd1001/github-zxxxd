package com.git.zxxxd.guice.demo.spring.hello.guiceCode;

import com.git.zxxxd.guiceDependency.helloworddemo.MyDestination;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class WebDestination implements MyDestination {
    private StringBuilder sb=new StringBuilder();

    public WebDestination() {
        System.out.println("WebDestination");
    }

    @Override
    public void write(String s) {
        sb.append(s);
    }
    public String getResult(){
        return sb.toString();
    }
}
