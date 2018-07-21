package tech.blur.eventhub.features.event.my.presenter;

import android.content.Context;

import tech.blur.eventhub.App;
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
