package com.git.zxxxd.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
    }

    public void starting() {
        System.out.println("SpringApplicationRunListener ...starting");
    }

    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
        Object o=configurableEnvironment.getSystemEnvironment().get("os.name");
        System.out.println("SpringApplicationRunListener.environmentPrepared: "+o);
    }

    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener..contextPrepared");
    }

    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener..contextLoaded");
    }

    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println("SpringApplicationRunListener..finished");
    }
}
