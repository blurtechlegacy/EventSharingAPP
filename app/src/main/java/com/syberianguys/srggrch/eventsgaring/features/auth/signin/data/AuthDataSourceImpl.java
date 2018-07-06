package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class AuthDataSourceImpl implements AuthDataSource {

    final private AuthApi authApi;

    public AuthDataSourceImpl(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public void checkAuth(String login, String pass) {

    }

    @Override
    public void getId(String id, Carry<User> carry) {

    }
}
