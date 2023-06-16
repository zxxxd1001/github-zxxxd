package com.git.zxxxd.optional;

import com.git.zxxxd.entity.Person;

import java.util.*;

public class OptionalDemo {
    public static void main(String[] args) {
        //创建
//        create();

        //取值
//        get();

        //过滤
        filter();

        //判断
//        isOrNull();

    }

    private static void isOrNull() {
        String s="hello";
        boolean bool = Optional.ofNullable(s).isPresent();
        System.out.println(bool);

        Optional.ofNullable(s).ifPresent(System.out::println);
    }

    private static void filter() {
        List l=new ArrayList();
        l.add(1);
        l.add(2);
        Optional.ofNullable(l).filter(item -> {
            System.out.println("filter");
            System.out.println(item);
            return true;
        });

        Map m=new HashMap<>();
        Person p=new Person();
        p.setName("张三");
        m.put("1",p);
        Optional<Object> o = Optional.ofNullable(m).map(x -> x.get("1"));
        Optional<String> s=o.map(x -> ((Person) x).getName());
        System.out.println(s.orElse("结果为空"));

        Optional<Object> o1 = Optional.ofNullable(m).flatMap(x -> Optional.ofNullable(x.get("1")));
        System.out.println(o1);
    }

    private static void get() {
        String hello = Optional.ofNullable("hello").get();
        System.out.println("hello="+hello);

        Integer integer = null;
        Integer orElse = Optional.ofNullable(integer).orElse(6);
        System.out.println("orElse="+orElse);

        Integer orElseGet = Optional.ofNullable(integer).orElseGet(() ->6);
        System.out.println("orElseGet="+orElseGet);
        Integer orElseThrow = Optional.ofNullable(integer).orElseThrow(() -> new RuntimeException("空参数异常"));
        System.out.println("orElseThrow="+orElseThrow);
    }


    private static void create() {
        List<String> dataList = new ArrayList<>();
        Optional<Object> empty = Optional.empty();
        Optional<List<String>> of = Optional.of(dataList);
        Optional<List<String>> ofNullable = Optional.ofNullable(dataList);
    }
}
