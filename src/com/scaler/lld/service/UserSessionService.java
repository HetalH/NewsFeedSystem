package com.scaler.lld.service;

import com.scaler.lld.model.UserSession;

import java.util.Map;

public interface UserSessionService {
    String getUserSession(String userId);
    String saveUserSession(String userId);
}
