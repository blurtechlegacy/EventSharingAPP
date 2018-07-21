package tech.blur.eventhub.features.event.my.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface MyEventsRepository {
    void getMyEventsList(String userHost,Carry<List<Event>> carry) ;
}
