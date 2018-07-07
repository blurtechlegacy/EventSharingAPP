package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;

public interface SignInView extends MvpView {

        void showProgress();

        void hideProgress();

        void showError(String message);


}
