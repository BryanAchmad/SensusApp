package com.example.sensusapp;

import com.example.sensusapp.Model.User;

public class UserResponse {

    private String token;
    private User user;

    public UserResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
