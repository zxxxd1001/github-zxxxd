package com.git.zxxxd.server.bind;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

public class ChinaModule extends AbstractModule {
    @Override
    protected void configure() {
        MapBinder.newMapBinder(binder(),String.class,String.class).addBinding("1+1").toInstance("2");
    }
}
