package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage;

import android.content.Context;

public class AuthLocalReposirtoryFactory {
    public static AuthLocalRepository create(final Context context){
        final AuthLocalDataSource dataSource = new AuthLocalDataSourceImpl(context);
        return new AuthLocalRepositoryImpl(dataSource);
    }
}
