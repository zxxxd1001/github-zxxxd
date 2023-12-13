package com.git.zxxxd.demo.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FluxTest {

    private void testJustCreateDelayInterval(){
        Flux<String> just = Flux.just("!@3");
        Flux<Object> objectFlux = Flux.create(sink -> {
            System.out.println(sink);
            // FluxSink 除了 next()、complete() 和 error() 这三个核心方法外，
            // 还定义了背压策略，并且可以在一次调用中产生多个元素
            for (int i=0;i<2;i++) {
                sink.next(i);
            }
            sink.complete();
        });
        objectFlux.subscribe(System.out::println);
        Flux<Long> interval = Flux.interval(Duration.ofMillis(1000));
        interval.delaySubscription(Duration.ofMillis(2000))
                .subscribe(System.out::println);

        //SynchronousSink 组件包括 next()、complete() 和 error() 这三个核心方法。
        //从 SynchronousSink 组件的命名上就能知道它是一个同步的 Sink 组件，也就是说元素的生成过程是同步执行的。
        //这里要注意的是 next() 方法只能最多被调用一次。
        Flux<Object> generate = Flux.generate(()->1,(i,synchronousSink) -> {
            synchronousSink.next(i);
            if (i==5) {
                synchronousSink.complete();
            }
            return ++i;
        });
        generate.subscribe(System.out::println);
    }

    private void testEmptyErrorNever() {
        Flux<Object> empty = Flux.empty();
        Flux<Object> error = Flux.error(new RuntimeException("错误"));
        Flux<Object> never = Flux.never();
        println("testEmptyErrorNever");
    }

    private void testLog() {
        Flux.range(1, 2).log("Flux testLog")
                .subscribe(System.out::println);
    }

    private void testRetry() {
        Flux.range(1, 3)
//                .concatWith(Mono.error(new IllegalStateException()))
                .map(item -> {
                    Mono.error(new IllegalStateException("asdad"));
                    return item;
                })
                .retry(2)
                .subscribe(System.out::println);
    }

    /**
     * map操作符转换流中的每个元素
     * flatMap 操作符把流中的每个元素转换成一个流，再把所有流中的元素进行合并。
     */
    private void testMap() {
        Flux<Integer> map = Flux.just("1", "2", "3")
                .map(item -> {
                    return Integer.valueOf(item) + 2;
                });
        map.subscribe(System.out::println);
        System.out.println();
        Flux<Integer> flux = Flux.just("1", "2", "3")
                .flatMap(item -> {
                    return Flux.just(Integer.valueOf(item) + 3);
                });
        flux.subscribe(System.out::println);
        System.out.println();
        Flux<Integer> concatMap = Flux.just("1", "2")
                .concatMap(item -> Flux.just(Integer.valueOf(item) + 4));
        concatMap.subscribe(System.out::println);
        System.out.println();
        Mono<Map<Integer, String>> mapMono = Flux.just("1", "2", "3")
                .collectMap(item -> Integer.valueOf(item) + 6);
        Map<Integer, String> block = mapMono.block();
        mapMono.subscribe(System.out::println);
        println("testMap");
    }

    private void testMerge() {
        Flux.merge(Flux.just("aaa", "bbb", "ccc"), Flux.range(1, 5))
                .subscribe(System.out::println);
        System.out.println();
        Flux.mergeSequential(Flux.just("ddd", "eee", "fff"), Flux.range(5, 2))
                .subscribe(System.out::println);
        println("testMerge");
    }

    /**
     * zipWith 操作符以一对一的方式合并两个流中的元素
     * <p>
     * 这个例子很有趣，e去哪里呢
     */
    private void testZipWith() {
        //这里 zipWith 操作符没有使用合并函数，因此结果流中的元素类型为 Tuple2。
        Flux.just("a", "b", "e")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);

        Flux.just("a", "b", "e")
                .zipWith(Flux.just("c", "d"), (x, y) -> String.format("%s-%s", x, y))
                .subscribe(System.out::println);

        println("testZipWith");
    }

    /**
     * reduce 和 reduceWith 操作符对流中包含的所有元素进行累积操作，得到一个包含计算结果的 Mono 序列。
     */
    private void testReduce() {
        Mono<String> reduce = Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx")
                .reduce((x, y) -> x + y);
        reduce.subscribe(System.out::println);

        //通过 Supplier 给出了初始值 init
        Mono<String> reduces = Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx")
                .reduceWith(() -> "init", (x, y) -> x + y);
        reduces.subscribe(System.out::println);

        println("testReduce");
    }

    /**
     * window 操作符是把当前流中的元素收集到另外的 Flux 序列中，因此返回值类型是 Flux<flux>。
     */
    private void testWindow() {
//        Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx").subscribe(System.out::println);
//        System.out.println();
        Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx")
                .window(3)
                .map(item -> {
                    if (item instanceof Flux) {
//                        System.out.println(item);
                        item.subscribe(System.out::println);
                    }
                    return item;
                })
                .subscribe(System.out::println);
        println("testWindow");
    }

    private void testFilter() {
        Flux.range(1, 10)
                .filter(item -> item % 4 == 0)
                .subscribe(System.out::println);
        println("testFilter");
    }

    /**
     * buffer 操作符的作用是把当前流中的元素收集到集合中，并把集合对象作为流中的新元素。
     * 在进行收集时可以指定不同的条件：所包含的元素的最大数量或收集的时间间隔。
     * <p>
     * bufferTimeout 指定在尝试从缓冲区中获取数据之前等待数据可用或超时的时间限制。
     * <p>
     * bufferUntil 会一直收集直到 Predicate 返回为 true。
     * <p>
     * bufferWhile 则只有当 Predicate 返回 true 时才会收集。
     */
    private void testBuffer() {
        Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx")
                .buffer(3)
                .subscribe(System.out::println);

        System.out.println();

        Flux.just("zhangsan", "lisi", "wangwu", "asdhashd", "pxx")
                .map(item -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return item;
                })
                .bufferTimeout(3, Duration.ofMillis(100))
                .subscribe(System.out::println);

        System.out.println();

        Flux.range(1, 10)
                .bufferUntil(item -> item % 4 == 0)
                .subscribe(System.out::println);

        System.out.println();

        Flux.range(1, 10)
                .bufferWhile(item -> item % 4 == 0)
                .subscribe(System.out::println);

        println("testBuffer");
    }

    private void testPublishOn() {
        Flux.range(1, 3)
                .map(item -> {
                    System.out.println(Thread.currentThread().getName());
                    return item;
                })
                .map(item -> {
                    System.out.println(Thread.currentThread().getName());
                    return item;
                })
                .publishOn(Schedulers.single())
                .map(item -> {
                    System.out.println(Thread.currentThread().getName());
                    return item;
                })
                .publishOn(Schedulers.newParallel("zxd", 4))
                .map(item -> {
                    System.out.println(Thread.currentThread().getName());
                    return item;
                })
                .subscribe(System.out::println);
        println("testPublishOn");
    }

    /**
     * 从当前流中提取元素。
     */
    private void testTake() {
        System.out.println("take 从前获取。");
        Flux.range(1, 1000)
                .take(5)
                .subscribe(System.out::println);

        System.out.println("takeLast 从后获取。");
        Flux.range(1, 1000)
                .takeLast(5)
                .subscribe(System.out::println);

        System.out.println("takeUntil 提取元素条件是真继续提取，假停止。");
        Flux.range(1, 5)
                .takeUntil(i -> i % 3 == 0)
                .subscribe(System.out::println);
        //这里也很有趣 只获取了一个值
        Flux.range(1, 5)
                .takeUntil(i -> i % 3 != 0)
                .subscribe(System.out::println);

        System.out.println("takeWhile  条件是真才进行提取。");
        Flux.range(1, 5)
                .takeWhile(i -> i % 3 == 0)
                .subscribe(System.out::println);
        Flux.range(1, 5)
                .takeWhile(i -> i % 3 != 0)
                .subscribe(System.out::println);
        println("testTake");
    }

    public static void main(String[] args) {
        FluxTest fluxTest = new FluxTest();
//        fluxTest.testTake();
//        fluxTest.testPublishOn();
//        fluxTest.testBuffer();
//        fluxTest.testFilter();
//        fluxTest.testWindow();
//        fluxTest.testReduce();
//        fluxTest.testZipWith();
//        fluxTest.testMerge();
//        fluxTest.testMap();
//        fluxTest.testRetry();
//        fluxTest.testLog();
//        fluxTest.testError();
//        fluxTest.testEmptyErrorNever();
        fluxTest.testJustCreateDelayInterval();
    }

    private static void println(String method) {
        System.out.println(String.format("===============> %s End", method));
    }

}
