package tech.blur.eventhub.features.event.full.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.core.events.model.Wrapper;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import java.util.List;

import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public final class FullEventDataSourceImpl implements FullEventDataSource {
    private final FullEventApi eventApi;

    public FullEventDataSourceImpl(FullEventApi eventApi) {
        this.eventApi = eventApi;
    }

    @Override
    public void getEvent(Carry<Event> carry, String id) {
        eventApi.getEvent(id).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void getTags(Carry<List<Tag>> carry) {
        eventApi.getTags().enqueue(new DefaultCallback(carry));
    }

    @Override
    public void assignEvent(AssignEvent assignEvent, Carry<Event> carry) {
        eventApi.assignEvents(assignEvent).enqueue(new DefaultCallback(carry));
    }
}
