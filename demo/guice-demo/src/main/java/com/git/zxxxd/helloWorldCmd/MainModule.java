package com.git.zxxxd.helloWorldCmd;

import com.git.zxxxd.helloWorldCmd.helloworddemo.HelloWordModule;
import com.git.zxxxd.helloWorldCmd.helloworddemo.PrintLineModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new HelloWordModule());
        install(new PrintLineModule());
    }
}
