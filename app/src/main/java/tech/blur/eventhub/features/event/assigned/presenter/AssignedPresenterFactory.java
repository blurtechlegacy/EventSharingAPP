package tech.blur.eventhub.features.event.assigned.presenter;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.event.assigned.data.AssignedApi;
import tech.blur.eventhub.features.event.assigned.data.AssignedDataSource;
import tech.blur.eventhub.features.event.assigned.data.AssignedDataSourceImpl;
import tech.blur.eventhub.features.event.assigned.data.AssignedRepository;
import tech.blur.eventhub.features.event.assigned.data.AssignedRepositoryImpl;
import tech.blur.eventhub.features.event.assigned.data.localstorage.AssignedLocalDataSource;
import tech.blur.eventhub.features.event.assigned.data.localstorage.AssignedLocalDataSourceImpl;
import tech.blur.eventhub.features.event.assigned.data.localstorage.AssignedLocalRepository;
import tech.blur.eventhub.features.event.assigned.data.localstorage.AssignedLocalRepositoryImpl;
import tech.blur.eventhub.features.event.assigned.domain.AssignInteractor;
import tech.blur.eventhub.features.event.assigned.domain.AssignInteractorImpl;
import tech.blur.eventhub.features.event.my.data.MyEventsApi;
import tech.blur.eventhub.features.event.my.data.MyEventsDataSource;
import tech.blur.eventhub.features.event.my.data.MyEventsDataSourceImpl;
import tech.blur.eventhub.features.event.my.data.MyEventsRepository;
import tech.blur.eventhub.features.event.my.data.MyEventsRepositoryImpl;
import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalDataSource;
import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalDataSourceImpl;
import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalRepository;
import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalRepositoryImpl;
import tech.blur.eventhub.features.event.my.domain.MyEventsInteractor;
import tech.blur.eventhub.features.event.my.domain.MyEventsInteractorImpl;
import tech.blur.eventhub.features.event.my.presenter.MyEventsPresenter;

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
