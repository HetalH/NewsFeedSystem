package com.scaler.lld.service.impl;

import com.scaler.lld.helper.SessionIdGenerator;
import com.scaler.lld.service.UserSessionService;

import java.util.HashMap;
import java.util.Map;

public class UserSessionServiceImpl implements UserSessionService {
    private Map<String, String> userSession;
    private SessionIdGenerator sessionIdGenerator;
    public UserSessionServiceImpl(){
        userSession = new HashMap<>();
        sessionIdGenerator = new SessionIdGenerator();
    }

    @Override
    public String getUserSession(String userId) {
       return userSession.get(userId);
    }

    public String saveUserSession(String userId) {
        if(userSession.containsKey(userId)){
            userSession.remove(userId);
        }
        String sessionId = sessionIdGenerator.generateSessionId();
        userSession.put(userId, sessionId);
        return sessionId;
    }
}
