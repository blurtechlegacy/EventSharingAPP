package com.syberianguys.srggrch.eventsgaring.features.auth.signup.presenter;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpApi;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpDataSource;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpRepository;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.domain.SignUpInteractor;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.domain.SignUpInteractorImpl;

public final class SignUpPresenterFactory {
    static SignUpPresenter createPresenter(Context context){
        final SignUpApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(SignUpApi.class);
        final SignUpDataSource dataSource = new SignUpDataSourceImpl(api);
        final SignUpRepository repository = new SignUpRepositoryImpl(dataSource);
        final SignUpInteractor interactor = new SignUpInteractorImpl(repository);

      return  new SignUpPresenter(interactor);
    }
}
