package com.scaler.lld.service;

import com.scaler.lld.exception.ExistingUserIdOrEmailIdException;
import com.scaler.lld.exception.InvalidUserIdOrPasswordException;
import com.scaler.lld.exception.PasswordReEnteredPasswordMismatch;
import com.scaler.lld.model.UserSession;

public interface UserService {
    void signUp(String userId, String emailId, String password, String reenteredPassword) throws ExistingUserIdOrEmailIdException, PasswordReEnteredPasswordMismatch;
    String authentic(String userId, String password) throws InvalidUserIdOrPasswordException;
}
