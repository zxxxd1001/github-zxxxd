package com.git.zxxxd.myobserver;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.doSomething();  // 触发通知

        subject.removeObserver(observer1);

        subject.doSomething();  // 触发通知
    }
}
