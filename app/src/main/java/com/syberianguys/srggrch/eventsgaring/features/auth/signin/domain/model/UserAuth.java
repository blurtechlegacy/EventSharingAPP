package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model;

public class UserAuth {
    String login;
    String password;

    public UserAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return password;
    }
}
