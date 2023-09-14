package com.git.zxxxd.myjavaevent;

import java.util.EventListener;
import java.util.EventObject;

public interface MyEventListener<T extends EventObject> extends EventListener {
    void onEventOccurred(T event);
}