package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

public class SignInPresenter {


    private String login;
    private String pass;

    void onSignInClicked (){

    }

    public void setLogin(CharSequence login) {
        this.login = (String) login;
    }

    public void setPass(CharSequence pass) {
        this.pass = (String) pass;
    }
}
