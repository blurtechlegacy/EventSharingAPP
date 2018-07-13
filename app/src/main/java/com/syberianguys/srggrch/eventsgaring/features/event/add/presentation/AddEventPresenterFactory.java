package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventApi;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.localstorage.AddEventLocalDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.localstorage.AddEventLocalDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.localstorage.AddEventLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.localstorage.AddEventLocalRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractorImpl;

public final class AddEventPresenterFactory  {
    static AddEventPresenter createPresenter(Context context) {
        final AddEventApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(AddEventApi.class);
        final AddEventDataSource dataSource = new AddEventDataSourceImpl(api);
        final AddEventRepository repository = new AddEventRepositoryImpl(dataSource);

        final AddEventLocalDataSource localDataSource = new AddEventLocalDataSourceImpl(context);
        final AddEventLocalRepository localRepository = new AddEventLocalRepositoryImpl(localDataSource);

        final AddEventInteractor interactor = new AddEventInteractorImpl(repository, localRepository);

        return new AddEventPresenter(interactor);
    }
}
