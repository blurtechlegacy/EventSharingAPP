package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthApi;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthDataSource;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthRepository;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.AuthRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.AuthInteractor;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.AuthInteractorImpl;

public class SignInPresenterFactory {

    static SignInPresenter createPresenter(Context context){
        final AuthApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(AuthApi.class);
        final AuthDataSource authDataSource = new AuthDataSourceImpl(api);
        final AuthRepository authRepository = new AuthRepositoryImpl(authDataSource);
        final AuthInteractor authInteractor = new AuthInteractorImpl(authRepository);


        return new SignInPresenter(authInteractor);
    }

}
