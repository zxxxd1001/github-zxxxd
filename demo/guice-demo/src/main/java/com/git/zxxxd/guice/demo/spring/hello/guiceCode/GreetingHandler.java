package com.git.zxxxd.guice.demo.spring.hello.guiceCode;

import com.git.zxxxd.guiceDependency.MyApplet;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class GreetingHandler {

    private MyApplet myApplet;
    private WebDestination webDestination;
    private RequestParmas requestParmas;

    @Inject
    public GreetingHandler(MyApplet myApplet, WebDestination webDestination, RequestParmas requestParmas) {
        this.myApplet = myApplet;
        this.webDestination = webDestination;
        this.requestParmas = requestParmas;
    }
    public String getResult(String str){
        requestParmas.setMessage(str);
        myApplet.run();
        return webDestination.getResult();
    }
}
