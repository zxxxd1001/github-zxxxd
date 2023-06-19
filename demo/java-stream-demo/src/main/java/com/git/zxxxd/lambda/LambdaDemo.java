package com.git.zxxxd.lambda;


import com.git.zxxxd.entity.Person;
import com.google.common.base.Strings;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {
//        functions();
//
//        doSomething(new LambdaTest() {
//            @Override
//            public void test() {
//                System.out.println("LambdaTest");
//            }
//        });

//        comparator();
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("eeee");
    }

    private static void comparator() {
        Comparator<Person> c = (Person p1, Person p2) -> p1.getAge().compareTo(p2.getAge());
        System.out.println(
                c.compare(
                        new Person(1,"张三","pass",25),
                        new Person(1,"李四","pass",30)
                )
        );
        Comparator<Person> cc = Comparator.comparing(Person::getAge);
        System.out.println(
                cc.compare(
                        new Person(1,"张三","pass",25),
                        new Person(1,"李四","pass",20)
                )
        );
    }

    private static void functions() {
        //功能
        Function<String,Integer> function=s->{
            return Integer.parseInt(s);
        };
        System.out.println(function.apply("123"));

        Consumer<String> consumer=s->{
            System.out.println(s);
        };
        consumer.accept("hello");

        //供应商，供应者
        Supplier<Integer> integerSupplier = () -> {
            return 1;
        };
        System.out.println(integerSupplier.get());

        //谓语
        Predicate<String> predicate=s->{
            return Strings.isNullOrEmpty(s);
        };
        System.out.println("是空吗="+predicate.test("123"));

        LambdaTest lambdaTest=()->{
            System.out.println("自定义Lambda");
        };
        lambdaTest.test();
    }


    public static void doSomething(LambdaTest lambdaTest){
        lambdaTest.test();
    }
}
