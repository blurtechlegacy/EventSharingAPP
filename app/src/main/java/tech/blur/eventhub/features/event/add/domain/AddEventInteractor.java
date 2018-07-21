package tech.blur.eventhub.features.event.add.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.add.presentation.Tag;

public interface AddEventInteractor {
    void addEvent(Event event, Carry<Event> carry);

    void addTag(Carry<List<Tag>> carry);
    User getUser();


}
