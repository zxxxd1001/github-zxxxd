package com.git.zxxxd.observer;

import java.util.Observable;
import java.util.Observer;

//定义观察者（Observer）
public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer notified: " + arg);
    }
}