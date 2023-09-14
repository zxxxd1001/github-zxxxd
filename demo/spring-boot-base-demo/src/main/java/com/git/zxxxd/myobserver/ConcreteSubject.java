package com.git.zxxxd.myobserver;

//实现被观察者类
public class ConcreteSubject implements Subject {

    public void doSomething() {
        // 做一些操作
        notifyObservers("Something happened!");
    }
}
