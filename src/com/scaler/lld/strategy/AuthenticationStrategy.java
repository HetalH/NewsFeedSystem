package com.scaler.lld.strategy;

public interface AuthenticationStrategy {
    boolean authentic(String userId, String password);
}
