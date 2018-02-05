package com.git.zxxxd.dependency.helloworddemo;

import com.git.zxxxd.dependency.MyApplet;

public class StringWritingApplet implements MyApplet {
    private MyDestination destination;
    private StringProvider stringProvider;

    public StringWritingApplet(MyDestination destination, StringProvider str) {
        this.destination = destination;
        this.stringProvider=str;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    public void run() {
        writeString();
    }
}
