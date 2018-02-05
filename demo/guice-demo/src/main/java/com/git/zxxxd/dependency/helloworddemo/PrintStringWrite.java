package com.git.zxxxd.dependency.helloworddemo;

import java.io.PrintStream;

public class PrintStringWrite implements MyDestination{
    private PrintStream destination;

    public PrintStringWrite(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String s) {
        destination.println(s);
    }
}
