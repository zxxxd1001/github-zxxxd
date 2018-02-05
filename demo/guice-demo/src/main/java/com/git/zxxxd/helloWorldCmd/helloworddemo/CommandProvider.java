package com.git.zxxxd.helloWorldCmd.helloworddemo;

import com.google.inject.Provider;

/**
 * Created by zhangxuedong on 2018/1/24.
 */
public class CommandProvider implements Provider<String> {
    private String [] args;

    public CommandProvider(String[] args) {
        this.args = args;
    }

    public String get() {
        return args[0];
    }
}
