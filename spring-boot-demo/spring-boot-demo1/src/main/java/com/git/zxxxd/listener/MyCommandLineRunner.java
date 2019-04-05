package com.git.zxxxd.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    public void run(String... strings) throws Exception {
        System.out.println("MyCommandLineRunner...");
    }
}
