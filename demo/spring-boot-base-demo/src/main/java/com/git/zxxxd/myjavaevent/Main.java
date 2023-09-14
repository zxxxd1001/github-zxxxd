package com.git.zxxxd.myjavaevent;

public class Main {
    public static void main(String[] args) {
        MyEventSource eventSource = new MyEventSource();
        MyEventListener listener = new MyEventListenerImpl();
        // 添加事件监听，手动添加改为启动扫描
        eventSource.addEventListener(listener);
        // 触发事件，封装单独的发布类，类似ApplicationEventPublisher
        eventSource.publishEvent(new MyEvent("Hello, world!","自定义"));
        // 删除事件监听
//        eventSource.removeEventListener(listener);
    }
}
