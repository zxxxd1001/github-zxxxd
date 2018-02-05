package com.git.zxxxd.server.Inject.impl;

import com.google.inject.Inject;

public class SessionManager {

    private Long sessionId;

    @Inject
    public SessionManager(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSessionId() {

        return sessionId;
    }
}
