package com.scaler.lld.helper;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class SessionIdGenerator {
    private static final Random random = new SecureRandom();
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String getSaltValue(int length)
    {
        StringBuilder finalval = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            finalval.append(characters.charAt(random.nextInt(characters.length())));
        }
        return new String(finalval);
    }

    public synchronized String generateSessionId(){
        String sessionId = getSaltValue(25);
        sessionId = sessionId + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(sessionId.getBytes());
    }
}
