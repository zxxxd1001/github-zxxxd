package com.git.zxxxd.server.servlet;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;

import javax.inject.Inject;

public class TestInjector {

    private Injector injector;

    @Inject
    public TestInjector(Injector injector) {
        this.injector = injector;
    }
    public void test(){
        GuiceFilter c=injector.getInstance(GuiceFilter.class);
        System.out.println("TestInjector: "+c.toString());
    }
}
