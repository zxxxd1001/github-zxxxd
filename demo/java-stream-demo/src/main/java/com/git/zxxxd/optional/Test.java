package com.git.zxxxd.optional;

import com.git.zxxxd.entity.Person;
import com.google.common.base.Strings;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("asd");
//        test(person);

//        test1();
//        test2("哈哈哈");
        test3();
    }

    private static void test3() {
        Person person = new Person(1,"李四","1234",25);
        String s = Optional.of(person).map(x -> x.getPass()).orElse("12345");
        System.out.println(s);
    }

    private static void test2(String string) {
        String s = Optional.ofNullable(string).filter(x->{
            if(Strings.isNullOrEmpty(x)){
                return false;
            }
            return true;
        }).orElse("入参是空，默认值");
        System.out.println("string="+s);
    }

    private static void test1() {
        //常规实现方式：
//        List<String> list = Arrays.asList("1");
//        List<String> list = null;
        List<String> list = new ArrayList<>();
        if (list != null) {
            for(String user: list){
                System.out.println(user);
            }
        }

        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(user -> {
            System.out.println(user);
        });
    }

    private static void test(Person person){
        // 使用Optional 和函数式编程，一行搞定，而且像说话一样
        boolean present = Optional.ofNullable(person).isPresent();
        //如果是空对出异常
        Person s = Optional.ofNullable(person).filter(item -> {
            if (Strings.isNullOrEmpty(item.getName())) {
                return false;
            }
            return true;
        }).orElseThrow(() -> new RuntimeException("空丢异常"));

        if (person== null) {
            System.out.println("空丢异常");
        }

    }

}
