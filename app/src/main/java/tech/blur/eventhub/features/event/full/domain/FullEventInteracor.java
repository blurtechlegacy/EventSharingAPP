package tech.blur.eventhub.features.event.full.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public interface FullEventInteracor {

    void loadEvent(Carry<Event> carry, String id);

    void getTags(Carry<List<Tag>> carry);

    void assignEvent (AssignEvent assignEvent, Carry<Event> carry);

    String getUserId();

}
