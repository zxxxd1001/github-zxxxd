package com.git.zxxxd.myjavaevent;

import java.util.EventObject;

public class MyEvent extends EventObject {
    private String eventData;

    public MyEvent(String source,String eventData) {
        super(source);
        this.eventData = eventData;
    }

    public String getEventData() {
        return eventData;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "eventData='" + eventData + '\'' +
                ", source=" + source +
                '}';
    }
}