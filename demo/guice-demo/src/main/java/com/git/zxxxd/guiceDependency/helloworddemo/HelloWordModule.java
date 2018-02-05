package com.git.zxxxd.guiceDependency.helloworddemo;


import com.git.zxxxd.guiceDependency.MyApplet;
import com.google.inject.AbstractModule;

import java.io.PrintStream;

public class HelloWordModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStringWrite.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("hello,word!!!");
        bind(String.class).toInstance("hello,word!!!");
    }
    //provider的写法
//    @Provides private String helloWord(){
//        return "hello,word!!!";
//    }

//        bind(String.class).toProvider(new Provider<String>() {
//            @Override
//            public String get() {
//                return "hello,word!!!";
//            }
//        });
}
