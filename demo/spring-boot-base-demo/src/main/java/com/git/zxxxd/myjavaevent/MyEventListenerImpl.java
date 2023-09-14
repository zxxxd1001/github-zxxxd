package com.git.zxxxd.myjavaevent;

public class MyEventListenerImpl implements MyEventListener<MyEvent> {
    @Override
    public void onEventOccurred(MyEvent event) {
        System.out.println("Event occurred: " + event);
    }
}
