package com.syberianguys.srggrch.eventsgaring.features.event.list.presentation;

import android.content.Context;

import com.syberianguys.srggrch.eventsgaring.App;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListApi;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListDataSource;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListDataSourceImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListRepositoryImpl;
import com.syberianguys.srggrch.eventsgaring.features.event.list.domain.ListInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.list.domain.ListInteractorImpl;

public class EventListPresenterFactory {
    public static EventListPresenter createPresenter(Context context){
        final ListApi listApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ListApi.class);
        final ListDataSource listDataSource = new ListDataSourceImpl(listApi);
        final ListRepository listRepository = new ListRepositoryImpl(listDataSource);
        final ListInteractor listInteractor = new ListInteractorImpl(listRepository);

        return new EventListPresenter(listInteractor);
    }
}
