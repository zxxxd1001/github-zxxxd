package com.git.zxxxd.server.bind;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * Created by zhangxuedong on 2018/1/23.
 */
public class GlobelMudole extends AbstractModule {
    @Override
    protected void configure() {
        MapBinder<String, String> stringStringMapBinder = MapBinder.newMapBinder(binder(), String.class, String.class);
        stringStringMapBinder.addBinding("1+2").toInstance("3");
        stringStringMapBinder.addBinding("1+3").toInstance("4");
    }
}
