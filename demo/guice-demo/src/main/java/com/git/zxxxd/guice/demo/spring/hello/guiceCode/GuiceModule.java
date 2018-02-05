package com.git.zxxxd.guice.demo.spring.hello.guiceCode;

import com.git.zxxxd.guiceDependency.MyApplet;
import com.git.zxxxd.guiceDependency.helloworddemo.MyDestination;
import com.git.zxxxd.guiceDependency.helloworddemo.Output;
import com.git.zxxxd.guiceDependency.helloworddemo.StringWritingApplet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);
    }
    @Provides @Output String getStr(GreetingMessageProvider provider){
        return provider.get();
    }
}
