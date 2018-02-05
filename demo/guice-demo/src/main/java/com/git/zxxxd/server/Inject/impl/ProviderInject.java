package com.git.zxxxd.server.Inject.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Created by zhangxuedong on 2018/1/17.
 */
public class ProviderInject {
    private Provider<Long> sessionId;

    @Inject
    public ProviderInject(Provider<Long> sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSessionId() {
        return sessionId.get();
    }
}
