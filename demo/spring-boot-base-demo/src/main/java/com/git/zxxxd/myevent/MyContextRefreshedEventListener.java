package com.git.zxxxd.myevent;

import com.git.zxxxd.controller.TestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        System.out.println("MyContextRefreshedEventListener 监听到事件");
        TestController testController = applicationContext.getBean("testController", TestController.class);
        Map<String, Object> hello = testController.hello();
        System.out.println(hello);
    }
}
