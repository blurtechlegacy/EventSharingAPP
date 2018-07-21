package tech.blur.eventhub.features.event.my.data.localstorage;

public class MyEventsLocalRepositoryImpl implements MyEventsLocalRepository
{
    private final MyEventsLocalDataSource myEventsLocalDataSource;

    public MyEventsLocalRepositoryImpl(MyEventsLocalDataSource myEventsLocalDataSource) {
        this.myEventsLocalDataSource = myEventsLocalDataSource;
    }

    @Override
    public String getUserHost() {
        return myEventsLocalDataSource.getUserHost();
    }
}
