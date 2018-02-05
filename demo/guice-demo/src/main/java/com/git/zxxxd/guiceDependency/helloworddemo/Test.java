package com.git.zxxxd.guiceDependency.helloworddemo;

import com.git.zxxxd.guiceDependency.MyApplet;

import javax.inject.Inject;

/**
 * Created by zhangxuedong on 2018/1/12.
 */
public class Test {
    private MyApplet myApplet;

    @Inject
    public Test(MyApplet myApplet) {
        this.myApplet = myApplet;
    }
}
