package tech.blur.eventhub.features.event.list.presentation;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.event.list.data.ListApi;
import tech.blur.eventhub.features.event.list.data.ListDataSource;
import tech.blur.eventhub.features.event.list.data.ListDataSourceImpl;
import tech.blur.eventhub.features.event.list.data.ListRepository;
import tech.blur.eventhub.features.event.list.data.ListRepositoryImpl;
import tech.blur.eventhub.features.event.list.data.localstorage.ListLocalDataSource;
import tech.blur.eventhub.features.event.list.data.localstorage.ListLocalDataSourceImpl;
import tech.blur.eventhub.features.event.list.data.localstorage.ListLocalRepository;
import tech.blur.eventhub.features.event.list.data.localstorage.ListLocalRepositoryImpl;
import tech.blur.eventhub.features.event.list.domain.ListInteractor;
import tech.blur.eventhub.features.event.list.domain.ListInteractorImpl;

public class EventListPresenterFactory {
    public static EventListPresenter createPresenter(Context context){
        final ListApi listApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ListApi.class);
        final ListDataSource listDataSource = new ListDataSourceImpl(listApi);
        final ListRepository listRepository = new ListRepositoryImpl(listDataSource);

        final ListLocalDataSource listLocalDataSource = new ListLocalDataSourceImpl(context);
        final ListLocalRepository localRepository = new ListLocalRepositoryImpl(listLocalDataSource);

        final ListInteractor listInteractor = new ListInteractorImpl(listRepository, localRepository);

        return new EventListPresenter(listInteractor);
    }
}
