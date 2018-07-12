package com.syberianguys.srggrch.eventsgaring.features.auth.signup.presenter;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;

public interface SignUpView extends MvpView{
    void showProgress();

    void hideProgress();

    void showError(String message);


}
