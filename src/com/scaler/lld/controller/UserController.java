package com.scaler.lld.controller;

import com.scaler.lld.exception.ExistingUserIdOrEmailIdException;
import com.scaler.lld.exception.InvalidUserIdOrPasswordException;
import com.scaler.lld.exception.PasswordReEnteredPasswordMismatch;
import com.scaler.lld.service.UserService;

public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    public void signUp(String userId, String emailId, String password, String reenteredPassword) throws ExistingUserIdOrEmailIdException, PasswordReEnteredPasswordMismatch {
        userService.signUp(userId,emailId,password,reenteredPassword);
    }

    public String authentic(String userId, String password) throws InvalidUserIdOrPasswordException {
        return userService.authentic(userId, password);
    }
}
