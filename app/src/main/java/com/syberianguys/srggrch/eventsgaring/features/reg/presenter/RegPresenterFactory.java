package com.syberianguys.srggrch.eventsgaring.features.reg.presenter;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegApi;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegDataSource;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegRepository;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.reg.domain.RegInteractor;
import com.syberianguys.srggrch.eventsgaring.features.reg.domain.RegInteractorImpl;

public final class RegPresenterFactory {
    static RegPresenter createPresenter(Context context){
        final RegApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(RegApi.class);
        final RegDataSource dataSource = new RegDataSourceImpl(api);
        final RegRepository repository = new RegRepositoryImpl(dataSource);
        final RegInteractor interactor = new RegInteractorImpl(repository);

      return  new RegPresenter(interactor);
    }
}
