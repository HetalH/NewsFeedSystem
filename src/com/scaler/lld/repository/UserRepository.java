package com.scaler.lld.repository;

import com.scaler.lld.helper.PasswordEncryptionHelper;
import com.scaler.lld.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }
    public void signUp(String userId, String emailId, String password){
       User user = new User(userId,emailId, PasswordEncryptionHelper.generateSecurePassword(password));
       users.add(user);
    }
    public boolean isExistingUserId(String userId){
        return getUser(userId) !=null;
    }
    public boolean isExistingEmailId(String emailId){
        return getUserByEmailId(emailId)!=null;
    }

    public User getUser(String userId){
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
    public User getUserByEmailId(String emailId){
        return users.stream()
                .filter(user -> user.getEmailId().equals(emailId))
                .findFirst()
                .orElse(null);
    }
}
