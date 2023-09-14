package com.git.zxxxd.myevent;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 只对MyEvent类型的事件作出响应
@Component
//@Order(997)
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("接口实现");
//        System.out.println("MyEventListener 监听到事件" + event.toString());
    }
}