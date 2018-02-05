package com.git.zxxxd.helloWorldCmd.helloworddemo;

import javax.inject.Inject;
import java.io.PrintStream;

public class PrintStringWrite implements MyDestination {
    private PrintStream destination;

    @Inject
    public PrintStringWrite(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String s) {
        destination.println(s);
    }
}
