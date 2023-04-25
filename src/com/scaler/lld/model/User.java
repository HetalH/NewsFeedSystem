package com.scaler.lld.model;

public class User {
    private String id;
    private String userId;
    private String emailId;
    private String password;

    public User(String userId, String emailId, String password) {
        this.userId = userId;
        this.emailId = emailId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}
