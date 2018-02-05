package com.git.zxxxd.guice.demo.spring.hello.guiceCode;

import com.git.zxxxd.guice.demo.spring.hello.dao.HelloDao;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.springframework.context.ApplicationContext;

public class SpringAwareServletModule extends AbstractModule{
    private ApplicationContext context;
    public SpringAwareServletModule(ApplicationContext context) {
        this.context=context;
    }

    @Override
    protected void configure() {
        install(new ServletModule());
        bind(ApplicationContext.class).toInstance(context);
    }
    @Provides
    HelloDao getDao(ApplicationContext context){
        return context.getBean(HelloDao.class);
    }
}
