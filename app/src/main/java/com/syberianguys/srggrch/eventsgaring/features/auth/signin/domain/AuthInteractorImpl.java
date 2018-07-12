package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthRepository;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage.AuthLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class AuthInteractorImpl implements AuthInteractor {

    private final AuthRepository authRepository;
    private final AuthLocalRepository authLocalRepository;

     public AuthInteractorImpl(AuthRepository authRepository, AuthLocalRepository authLocalRepository) {
        this.authRepository = authRepository;
         this.authLocalRepository = authLocalRepository;
     }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<User> carry) {
        authRepository.auth(userAuth, carry);
    }

    @Override
    public void putUser(User user) {
        authLocalRepository.putUserData(user);

    }

    @Override
    public void putIsAuth(boolean isAuth) {
        authLocalRepository.putIsAuth(isAuth);
    }
}
