package com.git.zxxxd.demo.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonoTest {

    private List<String> defaultList, list;

    public MonoTest() {
        defaultList = new ArrayList<>();
        defaultList.add("1");
        defaultList.add("2");
        defaultList.add("3");

        list = new ArrayList<>();
        list.add("999");
        list.add("888");
        list.add("777");
        list.add("666");
        list.add("555");
        list.add("444");
        list.add("333");
        list.add("222");
        list.add("111");
    }

    private void testEmptyErrorNever() {
        Mono<Object> empty = Mono.empty();
        Mono<Object> error = Mono.error(new RuntimeException("错误"));
        Mono<Object> never = Mono.never();
        println("testEmptyErrorNever");
    }


    private void testLog() {
        Mono.just(1).log("Mono testLog").subscribe(System.out::println);
        println("testLog");
    }

    private void testRetry() {
        Mono.just("asdad").concatWith(Mono.just("hhhhhh")).subscribe(System.out::println);

        Mono.just("asdad")
                .concatWith(Mono.error(new IllegalStateException()))
                .retry(2)
                .subscribe(System.out::println);
    }

    private void testMerge() {
        Mono.just("aaaa")
                .mergeWith(Mono.just("hhh"))
                .mergeWith(Mono.just("ssss"))
                .subscribe(System.out::println);
        println("testMerge");
    }

    private void testZipWith() {
        //这里 zipWith 操作符没有使用合并函数，因此结果流中的元素类型为 Tuple2。
        Mono.just("a")
                .zipWith(Mono.just("c"))
                .subscribe(System.out::println);

        Mono.just("a")
                .zipWith(Mono.just("c"), (x, y) -> String.format("%s-%s", x, y))
                .subscribe(System.out::println);
        println("testZipWith");
    }

    private void testPublishOn() {
        Mono.just(list)
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

    private void testFilter() {
        List<String> collect = list.stream().filter(e -> e.equals("999")).collect(Collectors.toList());
        System.out.println(collect);

        Mono.justOrEmpty(list)
                .filter(item -> false)
                .switchIfEmpty(Mono.just(defaultList))
                .subscribe(System.out::println);
        println("testFilter");
    }

    private void testFlatMap() {
        Mono.justOrEmpty(list)
                .flatMap(map -> {
                    List<String> collect = map.stream().filter(item -> item.equals("999")).collect(Collectors.toList());
                    return Mono.just(collect);
                })
                .switchIfEmpty(Mono.just(defaultList))
                .subscribe(item -> {
                    System.out.println(item);
                });
        println("testFlatMap");
    }

    private void testMap() {
        Mono.justOrEmpty(list)
                .map(item -> item.equals("999") ? item : Mono.empty())
                .switchIfEmpty(Mono.just(defaultList))
                .subscribe(System.out::println);
        println("testMap");
    }

    private void testTake() {
        Mono.just("asdasd")
                .map(item -> {
                    System.out.println(item);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return item;
                })
                .take(Duration.ofMillis(100))
                .subscribe(System.out::println);
        println("testTake");
    }

    public static void main(String[] args) {
//        Mono.just("hello")
//                .map(a -> a + " reactor")
//                .subscribe(System.out::println);

        MonoTest monoTest = new MonoTest();
//        monoTest.testTake();
//        monoTest.testMap();
//        monoTest.testFlatMap();
//        monoTest.testFilter();
        /**
         * publishOn()和subscribeOn()方法，能够创建线程
         * publishOn()操作会强制下一个操作符（或许是下一个的下一个…）运行于不同的线程上。
         *
         * publishOn()和其他操作符一样也处于整个订阅操作链中，从上游源获取元素，
         * 从关联的Scheduler获取一个 worker，并调用对应的schedule()方法向下游发放元素。
         */
//        monoTest.testPublishOn();
//        monoTest.testZipWith();
//        monoTest.testMerge();
//        monoTest.testRetry();
//        monoTest.testLog();
        monoTest.testEmptyErrorNever();
    }

    private static void println(String method) {
        System.out.println(String.format("===============> %s End", method));
    }

}
