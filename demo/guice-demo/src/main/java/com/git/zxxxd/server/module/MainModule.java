package com.git.zxxxd.server.module;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).toInstance("MainModule");
    }
}
