package com.git.zxxxd.demo.reactivestreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SimpleSubscriber implements Subscriber {
    @Override
    public void onSubscribe(Subscription s) {
        // 3. Subscriber 通过 Subscription#request 来请求数据
        // 或者 Subscription#cancel 来取消数据发布
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(o);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("error");
    }

    @Override
    public void onComplete() {
        System.out.println("complete");
    }
}