package com.git.zxxxd.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;

public class Dog implements InitializingBean, DisposableBean, SmartInitializingSingleton {
    private String name = "wang cai";

    private Food food;

    public Dog() {
        System.out.println("----Dog的无参构造方法被执行");
    }
    @Autowired
    public void setFood(Food food) {
        this.food = food;
        System.out.println("----dog的food属性被注入");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----com.git.zxxxd.bean.Dog.afterPropertiesSet触发执行");
    }

    public void myInitMethod() {
        System.out.println("----com.git.zxxxd.bean.Dog.myInitMethod触发执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("----com.git.zxxxd.bean.Dog.destroy触发执行");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("----com.git.zxxxd.bean.Dog.afterSingletonsInstantiated触发执行");
    }
}