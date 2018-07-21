package tech.blur.eventhub.features.event.assigned.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface AssignInteractor  {
    void getMyEvents(String userHost,Carry<List<Event>> carry);
    String getUserHost();
}
