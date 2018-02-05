package com.git.zxxxd.server.bind;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import java.util.Arrays;
import java.util.List;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        //类名绑定
        bind(Runnable.class).to(MyThread.class);
        //实例绑定
        bind(String.class).toInstance("String");
        //连接绑定 在test中

        //Named命名绑定
        bind(String.class).annotatedWith(Names.named("sex")).toInstance("男");
        //注解命名绑定
        bind(String.class).annotatedWith(Sex.class).toInstance("女");

        //绑定泛型 使用泛型绑定的数据 获取时也要用泛型否则报错
        bind(new TypeLiteral<List<String>>(){})
                .annotatedWith(Names.named("list"))
                .toInstance(Arrays.asList("3","4","5"));

        //集合绑定set
        Multibinder<String> stringMultibinder = Multibinder.newSetBinder(binder(), String.class);
        stringMultibinder.addBinding().toInstance("你");
        stringMultibinder.addBinding().toInstance("我");
        install(new ChinaModule());
        install(new GlobelMudole());
    }
    //Provider绑定
    @Provides Long getSessionId(){
        return System.currentTimeMillis();
    }

    @Provides List<String> getSupportedCurrencies(PriceProvider priceProvider){
        return  priceProvider.getSupportedCurrencies();
    }
    @Provides List getList(){
        return  Arrays.asList("1","2");
    }
}
