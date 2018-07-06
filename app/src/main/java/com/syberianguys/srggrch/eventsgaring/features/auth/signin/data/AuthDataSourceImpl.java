package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

public class AuthDataSourceImpl implements AuthDataSource {

    final private AuthApi authApi;

    public AuthDataSourceImpl(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<UserAuth> carry) {
        authApi.CheckUser(userAuth).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void getUser(String id, Carry<User> carry) {
        authApi.GetUser(id).enqueue(new DefaultCallback(carry));
    }
}
