package com.git.zxxxd.helloWorldCmd;

import com.git.zxxxd.helloWorldCmd.helloworddemo.CommandProvider;
import com.git.zxxxd.helloWorldCmd.helloworddemo.Output;
import com.google.inject.AbstractModule;

public class CommandModule extends AbstractModule {
    private String [] args;

    public CommandModule(String[] args) {
        this.args = args;
    }
    protected void configure() {
        bind(String.class).annotatedWith(Output.class).toProvider(new CommandProvider(args));
    }
}
