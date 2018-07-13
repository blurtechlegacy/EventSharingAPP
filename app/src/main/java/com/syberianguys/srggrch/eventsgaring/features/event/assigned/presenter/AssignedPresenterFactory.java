package com.syberianguys.srggrch.eventsgaring.features.event.assigned.presenter;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedApi;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.localstorage.AssignedLocalDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.localstorage.AssignedLocalDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.localstorage.AssignedLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.localstorage.AssignedLocalRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.domain.AssignInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.domain.AssignInteractorImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsApi;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.domain.MyEventsInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.my.domain.MyEventsInteractorImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.my.presenter.MyEventsPresenter;

public class AssignedPresenterFactory {
    public static AssignedPresenter createPresenter(Context context){
        final AssignedApi listApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(AssignedApi.class);
        final AssignedDataSource asDataSource = new AssignedDataSourceImpl(listApi);
        final AssignedRepository asRepository = new AssignedRepositoryImpl(asDataSource);

        final AssignedLocalDataSource asLocalDataSource = new AssignedLocalDataSourceImpl(context);
        final AssignedLocalRepository asLocalRepository = new AssignedLocalRepositoryImpl(asLocalDataSource);

        final AssignInteractor asInteractor = new AssignInteractorImpl(asRepository,asLocalRepository);

        return new AssignedPresenter(asInteractor);
    }
}
