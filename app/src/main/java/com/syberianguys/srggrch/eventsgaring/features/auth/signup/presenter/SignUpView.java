package com.syberianguys.srggrch.eventsgaring.features.auth.signup.presenter;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;

public interface SignUpView extends MvpView{
    void showProgress();

    void hideProgress();

    void showError(String message);

    boolean nameChecker(String name);

    boolean loginChecker(String login);

    boolean passwordChecker(String password);

    boolean confirmPasswordChecker(String password, String confirmPassword);

    boolean checker(String name , String login , String password, String confirmPassword);
}
