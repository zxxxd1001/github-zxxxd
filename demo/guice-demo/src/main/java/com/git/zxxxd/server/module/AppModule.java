package com.git.zxxxd.server.module;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(String.class).toInstance("AppModule");
        bind(Long.class).toInstance(System.currentTimeMillis());
    }
}
