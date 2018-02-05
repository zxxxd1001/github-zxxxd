package com.git.zxxxd.server.scope;

import com.google.common.cache.AbstractCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuiceDemoCache extends AbstractCache<String,String> {
    private Map<String,String> map=new ConcurrentHashMap<>();

    @Override
    public String getIfPresent(Object key) {
        return map.get(key);
    }

    @Override
    public void put(String key, String value) {
        map.put(key,value);
    }
}
