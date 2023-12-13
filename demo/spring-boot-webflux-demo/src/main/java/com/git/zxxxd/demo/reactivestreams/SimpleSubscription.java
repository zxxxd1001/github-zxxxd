package com.git.zxxxd.demo.reactivestreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SimpleSubscription implements Subscription {
    String data;
    Subscriber actual;
    boolean isCanceled;

    public SimpleSubscription(String data, Subscriber actual) {
        this.data = data;
        this.actual = actual;
    }

    @Override
    public void request(long n) {
        if (!isCanceled) {
            try {
                // 4. Subscription 在接收到订阅者的调用后
                // 通过 Subscriber#onNext 向下游订阅者传递数据
                actual.onNext(data);
                // 5. 在数据发布完成后，调用 Subscriber#onComplete 结束本次流
                actual.onComplete();
            } catch (Exception e) {
                // 如果数据发布或者处理遇到错误会调用 Subscriber#onError
                actual.onError(e);
            }
        }
    }

    @Override
    public void cancel() {
        isCanceled = true;
    }
}
