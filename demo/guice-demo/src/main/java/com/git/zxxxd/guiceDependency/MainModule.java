package com.git.zxxxd.guiceDependency;

import com.git.zxxxd.guiceDependency.helloworddemo.HelloWordModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new HelloWordModule());
    }
}
