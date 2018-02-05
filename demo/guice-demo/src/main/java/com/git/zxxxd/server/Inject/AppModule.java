package com.git.zxxxd.server.Inject;

import com.git.zxxxd.server.Inject.impl.AnnotationInject;
import com.git.zxxxd.server.Inject.impl.OrderServiceImpl;
import com.git.zxxxd.server.Inject.impl.PaymentSerivceImpl;
import com.git.zxxxd.server.Inject.impl.PriceServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentSerivceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);

        bind(Long.class).annotatedWith(Names.named("NamesInject")).toInstance(123l);
        bind(Long.class).annotatedWith(AnnotationInject.class).toInstance(18l);
    }
    @Provides Long setSessionId(){
        return  System.currentTimeMillis();
    }
}
