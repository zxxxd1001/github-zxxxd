package com.git.zxxxd.myjavaevent;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class MyEventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void addEventListener(MyEventListener listener) {
        listeners.add(listener);
    }

    public void removeEventListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void publishEvent(EventObject eventData) {
        //这块不应该有循环，需要把listeners，按监听的EventObject缓存起来。
        //通过EventObject获取对应listeners执行
        for (EventListener event : listeners) {
            //这块应该判断EventObject的类型去执行对应的Listener
            if(event instanceof MyEventListener){
                ((MyEventListener)event).onEventOccurred(eventData);
            }
        }
    }
}
