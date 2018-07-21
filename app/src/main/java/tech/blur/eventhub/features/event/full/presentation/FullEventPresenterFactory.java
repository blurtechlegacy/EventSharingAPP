package tech.blur.eventhub.features.event.full.presentation;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.event.full.data.FullEventApi;
import tech.blur.eventhub.features.event.full.data.FullEventDataSource;
import tech.blur.eventhub.features.event.full.data.FullEventDataSourceImpl;
import tech.blur.eventhub.features.event.full.data.FullEventRepository;
import tech.blur.eventhub.features.event.full.data.FullEventRepositoryImpl;
import tech.blur.eventhub.features.event.full.data.localstorage.FullEventLocalDataSource;
import tech.blur.eventhub.features.event.full.data.localstorage.FullEventLocalDataSourceImpl;
import tech.blur.eventhub.features.event.full.data.localstorage.FullEventLocalRepository;
import tech.blur.eventhub.features.event.full.data.localstorage.FullEventLocalRepositoryImpl;
import tech.blur.eventhub.features.event.full.domain.FullEventInteracor;
import tech.blur.eventhub.features.event.full.domain.FullEventInteracorImpl;

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
