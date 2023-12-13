package com.git.zxxxd.demo.reactivestreams;

public class ReactiveMain {
    public static void main(String[] args) {
        // 1. Subscriber ”订阅“ Publisher
        new SimplePublisher().subscribe(new SimpleSubscriber());
    }
}
