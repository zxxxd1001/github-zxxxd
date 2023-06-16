package com.git.zxxxd.utils;

import com.git.zxxxd.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonUtils {

    public static List<Person> create(){
        List<Person> l = new ArrayList<>();
        l.add(new Person(1, "zhangsan", "psd",20));
        l.add(new Person(2, "张三", "psd",39));
        l.add(new Person(3, "lisi", "psd",25));
        l.add(new Person(4, "李四", "psd",15));
        l.add(new Person(5, "wangwu", "psd",8));
        l.add(new Person(6, "王五", "psd",10));
        l.add(new Person(7, "zhaoguizhen", "psd",26));
        l.add(new Person(8, "赵桂珍", "psd",24));
        l.add(new Person(9, "chenjing", "psd",23));
        l.add(new Person(10, "陈静", "psd",23));
        l.add(new Person(11, "wangcunyan", "psd",32));
        l.add(new Person(12, "王存焉", "psd",33));
        return l;
    }
}
