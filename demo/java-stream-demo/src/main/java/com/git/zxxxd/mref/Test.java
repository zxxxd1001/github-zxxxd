package com.git.zxxxd.mref;

import com.git.zxxxd.entity.Person;
import com.git.zxxxd.lambda.FriFunction;
import com.git.zxxxd.lambda.LambdaTest;
import com.git.zxxxd.utils.PersonUtils;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        staticRef();
//        methudRef();
        constrRef();
    }

    //构造函数引用
    private static void constrRef() {
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);
        FriFunction<Integer,String,String,Integer,Person> function=Person::new;
        Person person1 = function.apply(1, "张三", "pass", 26);
        System.out.println(person1);
    }

    //普通方法的方法引用
    private static void methudRef() {
        List<String> strings = Lists.newArrayList("xing", "guo");
        strings.stream().map(item -> item.length()).forEach(System.out::println);
        strings.stream().map(String::length).forEach(System.out::println);

        List<Person> personList = PersonUtils.create();
        personList.stream().map(Person::getName).forEach(System.out::println);
    }

    //静态方法的方法引用
    private static void staticRef() {
        List<String> strList = Lists.newArrayList("1", "2", "3");
        List<Integer> intList1 = strList.stream().map(item -> Integer.parseInt(item)).collect(Collectors.toList());
        System.out.println(intList1);
        List<Integer> intList2 = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(intList2);

    }
}