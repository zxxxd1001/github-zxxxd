package com.git.zxxxd;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class TestBackpressure {
    public static void main(String[] args) throws Exception{

        Subscriber<Integer> baseSubscriber = new BaseSubscriber<Integer>() {
            protected void hookOnSubscribe(Subscription subscription) {
                subscription.request(1);
            }

            protected void hookOnNext(Integer value) {
                System.out.println("receive:" + value);
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                }
                request(1);
            }

            protected void hookOnError(Throwable throwable) {
                throwable.printStackTrace();
                System.exit(1);
            }
        };

        Consumer<FluxSink<Integer>> consumer= sink -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("push: " + i);
                sink.next(i);
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Flux.create(consumer, FluxSink.OverflowStrategy.ERROR)
                .publishOn(Schedulers.newSingle("receiver"), 10)
                .subscribe(baseSubscriber);
        new CountDownLatch(1).await();
    }
}
