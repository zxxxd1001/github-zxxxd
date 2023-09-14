package com.git.zxxxd.observer;

import java.util.Observable;

//定义被观察者（Observable）：
public class MyObservable extends Observable {

    public void doSomething() {
        // 做一些操作
        setChanged();  // 标记状态已改变
        notifyObservers("Something happened!");  // 通知观察者
    }
}
