package tech.blur.eventhub.features.event.assigned.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface AssignedRepository {
    void getAssignedEventsList(String userHost,Carry<List<Event>> carry) ;
}
