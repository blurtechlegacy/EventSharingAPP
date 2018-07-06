package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

class AuthInteractorImpl implements AuthInteractor {

    private final AuthDataSourceImpl authDataSource;

    AuthInteractorImpl(AuthDataSourceImpl authDataSource) {
        this.authDataSource = authDataSource;
    }

    @Override
    public void loadUser(String id, Carry<User> carry) {
        authDataSource.getUser(id, carry);
    }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<UserAuth> carry) {
        authDataSource.checkAuth(userAuth, carry);
    }
}
