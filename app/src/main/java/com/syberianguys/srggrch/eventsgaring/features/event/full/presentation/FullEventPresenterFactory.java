package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventApi;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage.FullEventLocalDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage.FullEventLocalDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage.FullEventLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage.FullEventLocalRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.FullEventInteracor;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.FullEventInteracorImpl;

public class FullEventPresenterFactory {
    static FullEventPresenter createPresenter(Context context){
        final FullEventApi eventApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(FullEventApi.class);
        final FullEventDataSource eventDataSource = new FullEventDataSourceImpl(eventApi);
        final FullEventRepository eventRepository = new FullEventRepositoryImpl(eventDataSource);

        final FullEventLocalDataSource localDataSource = new FullEventLocalDataSourceImpl(context);
        final FullEventLocalRepository localRepository = new FullEventLocalRepositoryImpl(localDataSource);

        final FullEventInteracor eventInteracor = new FullEventInteracorImpl(eventRepository, localRepository);

        return new FullEventPresenter(eventInteracor);
    }
}
