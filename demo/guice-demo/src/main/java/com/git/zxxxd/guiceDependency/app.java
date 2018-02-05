package com.git.zxxxd.guiceDependency;

import com.git.zxxxd.guiceDependency.helloworddemo.StringWritingApplet;
import com.git.zxxxd.guiceDependency.helloworddemo.Test;
import com.google.inject.Guice;

/**
 * 去除依赖 dependency
 */
public class app {
    public static void main(String[] args) {
        //当有多个接口实现累如何处理、如何绑定、如何获取
        MyApplet mainApplet = Guice.createInjector(new MainModule()).getInstance(MyApplet.class);
        mainApplet.run();
        //如何获取具体那个类
        StringWritingApplet s=Guice.createInjector(new MainModule()).getInstance(StringWritingApplet.class);

        //类Guice会自己找
        Test t=Guice.createInjector(new MainModule()).getInstance(Test.class);
    }
}
