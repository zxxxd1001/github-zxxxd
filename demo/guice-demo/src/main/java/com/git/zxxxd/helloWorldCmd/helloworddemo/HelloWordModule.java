package com.git.zxxxd.helloWorldCmd.helloworddemo;

import com.git.zxxxd.helloWorldCmd.Applet;
import com.git.zxxxd.helloWorldCmd.MyApplet;
import com.google.inject.AbstractModule;

import java.io.PrintStream;

public class HelloWordModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyDestination.class).to(PrintStringWrite.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("HelloWordModule");
        Applet.register(binder(), MyApplet.class).named("hello").to(StringWritingApplet.class);
    }
}
