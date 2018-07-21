package tech.blur.eventhub.features.event.list.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface ListRepository {
    void loadSearchingEvents (String searchString,Carry<List<Event>> carry);

    void loadEvents(Carry<List<Event>> carry);
}
