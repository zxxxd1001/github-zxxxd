package com.git.zxxxd.guiceDependency.helloworddemo;

import com.git.zxxxd.guiceDependency.MyApplet;
import com.google.inject.Provider;

import javax.inject.Inject;

public class StringWritingApplet implements MyApplet {
    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,
                               @Output Provider<String> str,
                               String test) {
        this.destination = destination;
        this.stringProvider=str;
        System.out.println("test: "+test);
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    public void run() {
        writeString();
    }
}
