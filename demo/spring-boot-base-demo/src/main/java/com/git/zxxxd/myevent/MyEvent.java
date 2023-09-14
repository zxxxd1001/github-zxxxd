package com.git.zxxxd.myevent;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

public class MyEvent extends ApplicationEvent implements Serializable {
    private static final long serialVersionUID = 7099057108183571937L;

    public MyEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        System.out.println(source);
        return "MyEvent";
    }
}