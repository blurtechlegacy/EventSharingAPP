package tech.blur.eventhub.features.event.my.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalRepository;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public class MyEventsRepositoryImpl implements MyEventsRepository {
    private final MyEventsDataSource myEventsDataSource;

    public MyEventsRepositoryImpl(MyEventsDataSource myEventsDataSource) {
        this.myEventsDataSource = myEventsDataSource;
    }


    @Override
    public void getMyEventsList(String userHost,Carry<List<Event>> carry) {
        myEventsDataSource.getMyEvents(userHost,carry);
    }
}
