package tech.blur.eventhub.features.event.my.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import java.util.List;

public class MyEventsDataSourceImpl implements MyEventsDataSource{
    private final MyEventsApi myEventsApi;

    public MyEventsDataSourceImpl(MyEventsApi myEventsApi) {
        this.myEventsApi = myEventsApi;
    }

    @Override
    public void getMyEvents(String userHost, Carry<List<Event>> carry) {
        myEventsApi.getMyEventsList(userHost).enqueue(new DefaultCallback(carry));
    }
}
