package com.example.sensusapp;

import com.example.sensusapp.Model.User;

public class LoginResponse {

    String token;
    User user;

    public LoginResponse(String token, User user) {
        token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
