package com.git.zxxxd.observer;

public class Main {

    private static void jav() {
        MyObservable observable = new MyObservable();
        MyObserver observer = new MyObserver();

        observable.addObserver(observer);

        observable.doSomething();  // 触发通知

        observable.deleteObserver(observer);
    }

    public static void main(String[] args) {
//        jav();
        test();
    }

    private static void test() {
        MyBean bean = new MyBean();
        MyObservers observer = new MyObservers();

        bean.addPropertyChangeListener(observer);

        bean.setProperty("New Value 1");
        bean.setProperty("New Value 2");

        bean.removePropertyChangeListener(observer);

        bean.setProperty("New Value 3");
    }
}
