package com.git.zxxxd.oop.helloworddemo;

import com.git.zxxxd.oop.MyApplet;

public class HelloWordPrinter implements MyApplet {
    public static void getHelloWord() {
        System.out.println("hello，word");
    }

    public void run() {
        getHelloWord();
    }
}
