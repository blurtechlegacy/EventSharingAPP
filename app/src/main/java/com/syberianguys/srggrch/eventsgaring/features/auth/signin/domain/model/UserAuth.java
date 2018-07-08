package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model;

public class UserAuth {
    String login;
    String pass;

    public UserAuth(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
