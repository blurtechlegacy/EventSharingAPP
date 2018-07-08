package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventApi;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractorImpl;

public final class AddEventPresenterFactory  {
    static AddEventPresenter createPresenter(Context context) {
        final AddEventApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(AddEventApi.class);

        final AddEventDataSource dataSource = new AddEventDataSourceImpl(api);
        final AddEventRepository repository = new AddEventRepositoryImpl(dataSource);
        final AddEventInteractor interactor = new AddEventInteractorImpl(repository);

        return new AddEventPresenter(interactor);
    }
}
