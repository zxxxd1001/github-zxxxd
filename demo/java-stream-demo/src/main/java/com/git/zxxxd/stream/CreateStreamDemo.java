package com.git.zxxxd.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) {
        //使用java.util.Arrays.stream(T[] array)方法用数组创建流
        List<String> list = Arrays.asList("hello", "world", "stream");

        /**
         *  创建顺序流，由主线程按顺序对流执行操作
         */
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        System.out.println("=================创建顺序流==========================");
        /**
         * 创建并行流，内部以多线程并行执行的方式对流进行操作，
         * 需要注意使用并行流的前提是流中的数据处理没有顺序要求（会乱序，即使用了 forEachOrdered）
         */
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::println);
        System.out.println("=================创建并行流==========================");
        list.stream().parallel().forEach(System.out::println);

        System.out.println("=================各种创建stream的方式 start==========================");
//        createDemo();
    }

    private static void createDemo(){

        //Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        stream1.forEach(System.out::println);

        System.out.println("==================Stream.of end=========================");

        /**
         *  iterate 方法接受两个参数，第一个为初始化值，第二个为进行的函数操作 ，
         *  因为 iterator 生成的流为无限流，通过 limit 方法对流进行了截断，只生成 3 个偶数
         */
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(3);
        stream2.forEach(System.out::println);

        System.out.println("==================Stream.iterate end=========================");

        /**
         * generate 方法接受一个参数，方法参数类型为 Supplier ，由它为流提供值。
         * generate 生成的流也是无限流，因此通过 limit 对流进行了截断
         */
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

        System.out.println("==================Stream.generate end=========================");
    }
}
