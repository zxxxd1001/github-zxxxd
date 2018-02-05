package com.git.zxxxd.server.scope;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(new TypeLiteral<Cache<String,String>>(){}).to(GuiceDemoSingletonCache.class);
        bind(List.class).to(ArrayList.class).in(Singleton.class);
    }
    @Provides @Singleton Map<String,String> getMap(){
        return new HashMap<>();
    }
}
