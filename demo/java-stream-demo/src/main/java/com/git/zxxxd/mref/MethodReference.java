package com.git.zxxxd.mref;

import com.git.zxxxd.entity.Person;
import com.git.zxxxd.lambda.LambdaTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        //匿名类
        BiFunction<Student, String, String> f1 = new BiFunction<Student, String, String>() {
            @Override
            public String apply(Student student, String s) {
                return student.getPerson(s);
            }
        };
        //lambda
        BiFunction<Student, String, String> f2 = (student, s) -> student.getPerson(s);
        //method reference
        BiFunction<Student, String, String> f3 = Student::getPerson;

        System.out.println(getRef(new Student("ZANGSAN",12),"语文",f1));

        Person person=new Person(1,"张三","pass",123);
        printlnRef(person::getName);
    }

    private static void printlnRef(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    private static String getRef(Student student,String s,BiFunction<Student, String, String> biFunction){
        return biFunction.apply(student,s);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class Student {
        private String name;
        private int age;

        public String getPerson(String s) {
            return String.format("姓名：%s, 年龄：%s,科目：%s",name,age,s);
        }
    }
}