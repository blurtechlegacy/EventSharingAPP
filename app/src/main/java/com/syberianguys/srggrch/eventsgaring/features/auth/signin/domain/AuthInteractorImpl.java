package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthDataSource;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthRepository;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class AuthInteractorImpl implements AuthInteractor {

    private final AuthRepository authRepository;

     public AuthInteractorImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<User> carry) {
        authRepository.auth(userAuth, carry);
    }
}
