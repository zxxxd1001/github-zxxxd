package com.git.zxxxd.oop;

import com.git.zxxxd.oop.helloworddemo.HelloWordPrinter;

public class Configuration {
    public static HelloWordPrinter getMainApplet() {
        return  new HelloWordPrinter();
    }
}
