package com.scaler.lld.service.impl;

import com.scaler.lld.exception.ExistingUserIdOrEmailIdException;
import com.scaler.lld.exception.InvalidUserIdOrPasswordException;
import com.scaler.lld.exception.PasswordReEnteredPasswordMismatch;
import com.scaler.lld.repository.UserRepository;
import com.scaler.lld.service.UserService;
import com.scaler.lld.service.UserSessionService;
import com.scaler.lld.strategy.AuthenticationStrategy;
import com.scaler.lld.strategy.UserIdAuthenticationStrategy;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private AuthenticationStrategy authenticationStrategy;
    private UserSessionService userSessionService;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.authenticationStrategy = new UserIdAuthenticationStrategy(userRepository);
        this.userSessionService = new UserSessionServiceImpl();
    }
    @Override
    public void signUp(String userId, String emailId, String password, String reenteredPassword) throws ExistingUserIdOrEmailIdException, PasswordReEnteredPasswordMismatch {
        if(!password.equals(reenteredPassword)){
            throw new PasswordReEnteredPasswordMismatch("Password and re-entered password don't match. Try again....");
        }
        if(userRepository.isExistingUserId(userId) || userRepository.isExistingEmailId(emailId)){
            throw new ExistingUserIdOrEmailIdException("Given userId or emailId already exist");
        }
        userRepository.signUp(userId, emailId, password);
    }

    @Override
    public String authentic(String userId, String password) throws InvalidUserIdOrPasswordException {
         if(!authenticationStrategy.authentic(userId, password)){
                throw  new InvalidUserIdOrPasswordException("Invalid User Id or Password");
            }
        return userSessionService.saveUserSession(userId);
    }
}
