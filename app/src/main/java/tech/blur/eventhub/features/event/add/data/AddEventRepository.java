package tech.blur.eventhub.features.event.add.data;


import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.add.presentation.Tag;

public interface AddEventRepository {


    void addEvent(Event event,Carry<Event> carry);
    void addTags(Carry<List<Tag>> carry);
}
