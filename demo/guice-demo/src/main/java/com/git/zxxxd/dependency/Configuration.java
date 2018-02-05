package com.git.zxxxd.dependency;

import com.git.zxxxd.dependency.helloworddemo.StringWritingApplet;
import com.git.zxxxd.dependency.helloworddemo.PrintStringWrite;
import com.git.zxxxd.dependency.helloworddemo.StringProvider;

public class Configuration {
    public static MyApplet getMainApplet() {
        return  new StringWritingApplet(new PrintStringWrite(System.out), new StringProvider() {
            @Override
            public String get() {
                return "Hello,Word";
            }
        });
    }
}
