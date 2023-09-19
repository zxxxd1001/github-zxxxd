package com.git.zxxxd;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;

public class TestParallel {
    /**
     * parallel 将数据分成指定份数，随后调用 runOn 方法并行处理这些数据。
     * runOn    该方法参数指定的任务执行的线程环境。
     * 最后的 CountDownLatch 用于阻塞主线程，以免进程停止看不到效果。
     *
     * 调度器相当于 Reactor 中的 ExecutorService，不同的调度器定义不同的线程执行环境。
     * Schedulers 提供的静态方法可以创建不同的线程执行环境。
     * Schedulers.immediate() 直接在当前线程执行
     * Schedulers.single()    在一个重复利用的线程上执行
     * Schedulers.boundedElastic() 在由 Reactor 维护的线程池上执行，该线程池中闲置时间过长（默认值为 60s）的线程也将被丢弃，创建线程数量上限默认为 CPU 核心数 x 10。线程数达到上限后，最多可提交 10 万个任务，这些任务在线程可用时会被执行。该线程池可以为阻塞操作提供很好的支持。阻塞操作可以执行在独立的线程上，不会占用其他资源。
     * Schedulers.parallel()   固定线程，对于异步 IO，可以使用该方案。
     *
     */
    public static void main(String[] args) {
        try {
            Flux.range(0, 10)
                    .parallel()
                    .runOn(Schedulers.parallel())
                    .subscribe(i -> {
                        System.out.println(Thread.currentThread().getName() + " -> " + i);
                    });
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
