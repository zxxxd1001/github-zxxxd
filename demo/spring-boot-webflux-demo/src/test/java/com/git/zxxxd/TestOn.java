package com.git.zxxxd;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;

public class TestOn {
    /**
     * Reactor 另外提供了两个操作符方法来切换执行上下文，publishOn 和 subscribeOn。
     * publishOn 影响当前操作符方法后面操作的线程执行环境，而 subscribeOn 则影响整个链路的线程执行环境。
     * (runOn 与 publishOn 类似，影响该方法后续操作线程执行环境)
     */
    public static void main(String[] args) {
//        publishOn();
        subscribeOn();
    }

    private static void subscribeOn() {
        Consumer<Integer> myHandler = i -> {
            System.out.println(Thread.currentThread().getName() + " receive:" + i);
        };

        Flux.range(1, 3)
                .doOnNext(i -> {
                    System.out.println(Thread.currentThread().getName() + " doOnNext:" + i);
                })
                .subscribeOn(Schedulers.newParallel("myParallel"))
                .skip(1)
                .subscribe(myHandler);

    }

    private static void publishOn() {
        Consumer<Integer> myHandler = i -> {
            System.out.println(Thread.currentThread().getName() + " receive:" + i);
        };

        //publishOn 后面的操作（包括 skip，myHandler）都已经切换到新的线程。
        //线程切换是在 PublishOnSubscriber 中完成的，所以 PublishOnSubscriber 后面的操作都在新线程上。
        Flux.range(1, 3)
                .doOnNext(i -> {
                    System.out.println(Thread.currentThread().getName() + " doOnNext:" + i);
                })
                .publishOn(Schedulers.newParallel("myParallel"))
                .skip(1)
                .subscribe(myHandler);

    }
}
