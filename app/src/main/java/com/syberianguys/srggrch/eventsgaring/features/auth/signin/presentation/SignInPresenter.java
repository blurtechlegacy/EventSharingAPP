package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.AuthInteractor;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventsListActivity;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class SignInPresenter extends MvpPresenter<SignInView>{


    private final AuthInteractor authInteractor;


    private String login;
    private String pass;

    public SignInPresenter(AuthInteractor authInteractor) {
        this.authInteractor = authInteractor;
    }

    void onSignInClicked (){
        UserAuth userAuth =  new UserAuth(login, pass);
        if ((login != null)&&(pass!=null))
        authInteractor.checkAuth(userAuth, new Carry<User>() {
            @Override
            public void onSuccess(User result) {
                if (result != null) view.authOk();
                else view.authFailed();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });
    }

    public void onLoginChanged(CharSequence login) {
        this.login = login.toString();
    }

    public void onPassChanged(CharSequence pass) {
        this.pass = pass.toString();
    }
}
