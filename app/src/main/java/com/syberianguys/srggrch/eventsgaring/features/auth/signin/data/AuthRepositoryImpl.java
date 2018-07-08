package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class AuthRepositoryImpl implements AuthRepository {
    private final AuthDataSource authDataSource;

    public AuthRepositoryImpl(AuthDataSource authDataSource) {
        this.authDataSource = authDataSource;
    }

    @Override
    public void loadUser(String id, Carry<User> carry) {
        authDataSource.getUser(id, carry);
    }

    @Override
    public void auth(UserAuth userAuth, Carry<UserAuth> carry) {
        authDataSource.checkAuth(userAuth, carry);
    }
}
