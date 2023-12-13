package com.git.zxxxd.demo.reactivestreams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class SimplePublisher implements Publisher {
    @Override
    public void subscribe(Subscriber s) {
        // 2. Publisher 发布数据之前，调用 Subscriber 的 onSubscribe
        s.onSubscribe(new SimpleSubscription(data(), s));
    }

    private String data() {
        return "Hello World";
    }
}

