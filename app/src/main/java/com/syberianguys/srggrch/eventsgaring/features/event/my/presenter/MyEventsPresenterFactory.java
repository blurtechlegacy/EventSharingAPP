package com.syberianguys.srggrch.eventsgaring.features.event.my.presenter;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
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

public class MyEventsPresenterFactory {
    public static MyEventsPresenter createPresenter(Context context){
        final MyEventsApi listApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(MyEventsApi.class);
        final MyEventsDataSource myDataSource = new MyEventsDataSourceImpl(listApi);
        final MyEventsRepository myRepository = new MyEventsRepositoryImpl(myDataSource);

        final MyEventsLocalDataSource myLocalDataSource = new MyEventsLocalDataSourceImpl(context);
        final MyEventsLocalRepository myLocalRepository = new MyEventsLocalRepositoryImpl(myLocalDataSource);

        final MyEventsInteractor myInteractor = new MyEventsInteractorImpl(myRepository,myLocalRepository);

        return new MyEventsPresenter(myInteractor);
    }
}
