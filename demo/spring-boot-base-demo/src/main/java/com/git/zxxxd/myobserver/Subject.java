package com.git.zxxxd.myobserver;

import java.util.ArrayList;
import java.util.List;

//定义被观察者（主题）接口
public interface Subject {
    List<Observer> observers = new ArrayList<>();

    default void registerObserver(Observer observer) {
        observers.add(observer);
    }

    default void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    default void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
