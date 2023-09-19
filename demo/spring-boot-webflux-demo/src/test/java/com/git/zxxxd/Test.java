package com.git.zxxxd;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Test {

//    数据处理，如 skip，distinct，sort，filter
//    钩子方法，如 doOnNext，doOnSuccess
//    组合操作，flatMap，zipWhen
//    阻塞等待，blockLast
//    流量控制，limitRate
//    数据缓存，buffer，cache
//    可参考官方文档：https://projectreactor.io/docs/core/release/reference/#which-operator

    private static void testPush(){
        Flux.create(sink -> {
            System.out.println("please entry data");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    sink.next(br.readLine());
                } catch (IOException e) {
                }
            }
        }).subscribe(i -> {
            System.out.println("receive:" + i);
        });
    }

    private static void testPushOrPull() {
        //Reactor 提供了 push 和 pull 两种模式。
        Flux.generate(sink -> {
            int k = (int) (Math.random() * 10);
            if (k > 8)
                sink.complete();
            sink.next(k);
        }).subscribe(i -> {
            System.out.println("receive:" + i);
        });
    }

    private static void demo1() {
        Consumer<Integer> myHandler = i -> {
            System.out.println(Thread.currentThread().getName() + " receive:" + i);
        };

        Flux.range(1, 3)
                .doOnNext(i -> {
                    System.out.println(Thread.currentThread().getName() + " doOnNext:" + i);
                })
                .skip(1)
                .subscribe(myHandler);
    }

    private static void demo() {
        // 发布者Publisher负责生产数据
        // 有两种发布者，Flux 可以生产 N 个数据，Mono 可以生产 0~1 个数据。
//        Flux<Integer> flux = Flux.range(1, 10);
        Flux<Integer> flux = Flux.fromArray(new Integer[]{1, 2, 3, 10});
        // 订阅者Subscriber负责处理，消费数据。
        Subscriber<Integer> subscriber = new BaseSubscriber<Integer>() {
            protected void hookOnNext(Integer value) {
                System.out.println(Thread.currentThread().getName() + " -> " + value);
                request(1);
            }
        };
        // 创建订阅关系，这时，生产者开始生产数据，并传递给订阅者。
        flux.subscribe(subscriber);
    }

    public static void main(String[] args) {
//        demo();
//        demo1();
//        testPushOrPull();
        testPush();
    }
}
