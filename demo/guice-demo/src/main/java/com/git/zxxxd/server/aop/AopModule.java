package com.git.zxxxd.server.aop;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;

public class AopModule extends AbstractModule {
    @Override
    protected void configure() {
        LogInterceptor l=new LogInterceptor();
        //手工new的对象Guice不管，其里面的inject的对象也无法拿到，
        //requestInjection将对象注入Guice中让其管理起来
        requestInjection(l);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Log.class),l);
    }
    @Provides Long setSessionId(){
        return System.currentTimeMillis();
    }
}
