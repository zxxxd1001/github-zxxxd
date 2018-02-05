package com.git.zxxxd.helloWorldCmd.helloworddemo;

import com.git.zxxxd.helloWorldCmd.MyApplet;
import com.google.inject.Provider;

import javax.inject.Inject;

public class StringWritingApplet implements MyApplet {
    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,
                               @Output Provider<String> str) {
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
