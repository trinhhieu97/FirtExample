package com.bachhoastore.controllers;

public class LoginRespond {
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginRespond(String token) {
        this.token = token;
    }
}
