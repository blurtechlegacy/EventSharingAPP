package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public class AuthLocalRepositoryImpl implements AuthLocalRepository {
    private final AuthLocalDataSource dataSource;

    public AuthLocalRepositoryImpl(AuthLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void putUserData(User user) {

    }

    @Override
    public User getUserData() {
        return null;
    }

    @Override
    public void putIsAuth(boolean isAuth) {
        dataSource.putIsAuth(isAuth);
    }
}
