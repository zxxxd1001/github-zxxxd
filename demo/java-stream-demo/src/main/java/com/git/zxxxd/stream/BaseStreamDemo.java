package com.git.zxxxd.stream;

import com.alibaba.fastjson.JSON;
import com.git.zxxxd.entity.Person;
import com.git.zxxxd.utils.NumberUtils;
import com.git.zxxxd.utils.PersonUtils;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseStreamDemo {
    public static void main(String[] args) {
        //筛选
//        filter();

        //映射
//        map();

//        peek();

//        unordered();

        //去重
//        distinct();

        //排序
//        sort();

        //截取，指定个数
//        limit();

        //跳过指定个数，截取
//        skip();

//        anyMatch();

//        reduce();
//        reduce1();
//        reduce2();

        collect();
    }

    private static void collect() {
        List<Integer> integers = NumberUtils.create();
//        List<Integer> collect = integers.stream().collect(Collectors.toList());
//        Set<Integer> collect = integers.stream().collect(Collectors.toSet());
//        ArrayList<Integer> collect = integers.stream().collect(Collectors.toCollection(ArrayList::new));
        //计算流中元素个数
//        Long collect = integers.stream().collect(Collectors.counting());
        //求和
//        Integer collect = integers.stream().collect(Collectors.summingInt(x -> x));
        //平均值
//        Double collect = integers.stream().collect(Collectors.averagingInt(x -> x));

//        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
//        String collect = strings.stream().collect(Collectors.joining());
        List<Person> personList = PersonUtils.create();
        String collect = personList.stream().map(Person::getName).collect(Collectors.joining(","));
//        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);

//        Integer integer = integers.stream().collect(Collectors.maxBy(Comparator.comparingInt(x->x))).get();
//        Integer integer = integers.stream().collect(Collectors.minBy(Comparator.comparingInt(x->x))).get();
//        System.out.println(integer);
    }

    private static void reduce2() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> other = new ArrayList<>();
        other.addAll(Arrays.asList(7, 8, 9, 10));

        num.parallelStream().reduce(other,
                (x, y) -> { //第二个参数
                    System.out.println(JSON.toJSONString(x));
                    x.add(y);
                    return x;
                },
                (x, y) -> { //第三个参数
                    System.out.println("并行才会出现：" + JSON.toJSONString(x));
                    return x;
                });
    }

    private static void reduce1() {
        List<Integer> num = Arrays.asList(1, 2, 4, 5, 6, 7);

        Integer integer = num.stream().reduce(1, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                System.out.println("a=" + a);
                System.out.println("b=" + b);
                return a + b;
            }
        });
        System.out.println("resutl:" + integer);
    }

    private static void reduce() {
        List<Integer> num = Arrays.asList(1, 2, 4, 5, 6, 7);
        Integer integer = num.stream().reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                System.out.println("x:"+a);
                System.out.println("y:"+b);
                return a + b;
            }
        }).get();
        System.out.println("resutl:"+integer);

        Integer result = num.stream().reduce((x, y) -> {
            System.out.println("x:"+x);
            return x + y;
        }).get();
        System.out.println("resutl:"+result);
    }

    private static void anyMatch() {
        boolean b = Stream.of(3,1,10,16,8,4,9).anyMatch(s -> s == 2);
        System.out.println("result="+b);
        b = Stream.of(3,1,10,16,8,4,9).anyMatch(s -> s == 3);
        System.out.println("result="+b);

        System.out.println("result="+Stream.of(3,1,10,16,8,4,9).allMatch(s->s>=1));

        System.out.println("result="+Stream.of(3,1,10,16,8,4,9).noneMatch(s -> s>=17 ));

        Optional<Integer> first = Stream.of(3, 1, 10, 16, 8, 4, 9).findFirst();
        System.out.println("result="+first.get());
        System.out.println("result="+Stream.of(3,1,10,16,8,4,9).filter(s-> s > 3).findFirst().get());

        List<String> strAry = Arrays.asList( "Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        String result = strAry.parallelStream().filter(s->s.startsWith("J")).findAny().get();
        System.out.println("result = " + result);
    }

    private static void skip() {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        stream.skip(3).forEach(System.out::println);
    }

    private static void limit() {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        stream.limit(3).forEach(System.out::println);
    }

    private static void sort() {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        stream.sorted().forEach(System.out::println);
        System.out.println("========");
        Stream<Integer> stream1 = Stream.of(3,1,10,16,8,4,9);
        stream1.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("========");
        List<Person> person=PersonUtils.create();
        person.stream().sorted(Comparator.comparing(Person::getId).reversed()).forEach(System.out::println);
    }

    private static void distinct() {
        Stream<String> stream = Stream.of("1", "3","4","10","4","6","23","3");
        stream.distinct().forEach(System.out::println);
    }

    private static void unordered() {
        List<Integer> integers = NumberUtils.create(0, 10);
        integers.stream().unordered().forEach(System.out::println);
        System.out.println("======");
        integers.stream().unordered().parallel().forEach(System.out::println);
    }

    private static void peek() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd","jkl", "jkl");
        strings.stream().peek(item ->item +="ss").forEach(System.out::println);
        List<Person> person=PersonUtils.create();
        person.stream().peek(item->item.setId(item.getId()+1)).forEach(System.out::println);

        Stream<String> stream = Stream.of("hello", "felord.cn");
        stream.peek(System.out::println);
    }


    private static void map() {
        /**
         * 接受一个函数作为参数。
         * 这个函数会被应用到每个元素上，并将其映射成一个新的元素
         * （使用映射一词，是因为它和转换类似，但其中的细微差别在于它是 "创建一个新版本" 而不是去"修改"）
         */
        List<Person> person=PersonUtils.create();
        List<String> mapped = person.parallelStream().map(item->item.getName()+"-IT").collect(Collectors.toList());
        System.out.println(mapped);

        //将People对象转化为Map
        Map<Integer, Person> collect = person.parallelStream().collect(Collectors.toMap(Person::getId, item -> item));
        System.out.println(collect);

        List<String> strings = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect1 = strings.stream().flatMap(item -> {
            // 将每个元素转换成一个stream
            String[] split = item.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        System.out.println(collect1);
    }

    private static void filter(){
        //筛选，是按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中的操作。
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2);
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(collect);

        List<Person> person=PersonUtils.create();
        List<Person> collect1 = person.stream().filter(item -> item.getAge() > 30).collect(Collectors.toList());
        System.out.println(collect1);
    }

}
