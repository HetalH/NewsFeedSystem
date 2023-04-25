package com.scaler.lld.strategy;

import com.scaler.lld.helper.PasswordEncryptionHelper;
import com.scaler.lld.model.User;
import com.scaler.lld.repository.UserRepository;

public class UserIdAuthenticationStrategy implements AuthenticationStrategy{
    private UserRepository userRepository;
    public UserIdAuthenticationStrategy(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public boolean authentic(String userId, String password) {
        User user = userRepository.getUser(userId);
        if(user != null && PasswordEncryptionHelper.verifyUserPassword(password, user.getPassword())){
            return true;
        }
        return false;
    }
}
