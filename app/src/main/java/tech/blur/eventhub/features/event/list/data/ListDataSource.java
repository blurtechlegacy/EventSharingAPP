package tech.blur.eventhub.features.event.list.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface ListDataSource {
    void getSearchEvents(String searchString, Carry<List<Event>> carry);
    void getEvents(Carry<List<Event>> carry);
}
