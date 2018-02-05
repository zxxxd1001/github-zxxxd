package com.git.zxxxd.helloWorldCmd.helloworddemo;


import com.git.zxxxd.helloWorldCmd.Applet;
import com.git.zxxxd.helloWorldCmd.MyApplet;
import com.google.inject.AbstractModule;

public class PrintLineModule extends AbstractModule {
    @Override
    protected void configure() {
        Applet.register(binder(), MyApplet.class).named("print").to(PrintLineApplet.class);
    }
}
