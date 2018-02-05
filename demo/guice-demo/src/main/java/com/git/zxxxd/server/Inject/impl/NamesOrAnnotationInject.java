package com.git.zxxxd.server.Inject.impl;

import com.google.inject.Inject;

import javax.inject.Named;

/**
 * Created by zhangxuedong on 2018/1/17.
 */
public class NamesOrAnnotationInject {
    private Long sessionId;
    private Long age;
    @Inject
    public NamesOrAnnotationInject(@Named("NamesInject") Long sessionId,
                                   @AnnotationInject Long age) {
        this.sessionId = sessionId;
        this.age=age;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public Long getAge() {
        return age;
    }
}
