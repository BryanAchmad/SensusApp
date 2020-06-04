package com.example.sensusapp;

import com.example.sensusapp.Model.User;

public class LoginResponse {

    String Token;
    User user;

    public LoginResponse(String token, User user) {
        Token = token;
        this.user = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
