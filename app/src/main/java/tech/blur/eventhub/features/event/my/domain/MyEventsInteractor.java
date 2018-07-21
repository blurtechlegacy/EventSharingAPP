package tech.blur.eventhub.features.event.my.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface MyEventsInteractor {
    void getMyEvents(String userHost,Carry<List<Event>> carry);
    String getUserHost();
}
