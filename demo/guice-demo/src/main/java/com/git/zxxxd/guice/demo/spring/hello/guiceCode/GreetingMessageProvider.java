package com.git.zxxxd.guice.demo.spring.hello.guiceCode;


import com.git.zxxxd.guice.demo.spring.hello.dao.HelloDao;
import com.google.inject.Provider;

import javax.inject.Inject;

public class GreetingMessageProvider implements Provider<String> {
    private RequestParmas requestParmas;
    private HelloDao helloDao;

    @Inject
    public GreetingMessageProvider(RequestParmas requestParmas, HelloDao helloDao) {
        this.requestParmas = requestParmas;
        this.helloDao = helloDao;
    }

    @Override
    public String get() {
        String message=requestParmas.getMessage();
        helloDao.save(message);
        return "Hello "+message;
    }
}
