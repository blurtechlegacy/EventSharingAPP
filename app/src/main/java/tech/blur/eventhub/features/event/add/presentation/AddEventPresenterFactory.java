package tech.blur.eventhub.features.event.add.presentation;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.event.add.data.AddEventApi;
import tech.blur.eventhub.features.event.add.data.AddEventDataSource;
import tech.blur.eventhub.features.event.add.data.AddEventDataSourceImpl;
import tech.blur.eventhub.features.event.add.data.AddEventRepository;
import tech.blur.eventhub.features.event.add.data.AddEventRepositoryImpl;
import tech.blur.eventhub.features.event.add.data.localstorage.AddEventLocalDataSource;
import tech.blur.eventhub.features.event.add.data.localstorage.AddEventLocalDataSourceImpl;
import tech.blur.eventhub.features.event.add.data.localstorage.AddEventLocalRepository;
import tech.blur.eventhub.features.event.add.data.localstorage.AddEventLocalRepositoryImpl;
import tech.blur.eventhub.features.event.add.domain.AddEventInteractor;
import tech.blur.eventhub.features.event.add.domain.AddEventInteractorImpl;

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
