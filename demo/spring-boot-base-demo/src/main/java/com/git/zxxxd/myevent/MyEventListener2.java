package com.git.zxxxd.myevent;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener2 {
    @EventListener(MyEvent.class)
//    @Order(998)
    @Async
    public void event(MyEvent myEvent){
        System.out.println("注解实现");
    }
}
