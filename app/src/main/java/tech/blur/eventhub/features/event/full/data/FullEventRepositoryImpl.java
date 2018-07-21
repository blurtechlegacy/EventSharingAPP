package tech.blur.eventhub.features.event.full.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public class FullEventRepositoryImpl implements FullEventRepository {

    private final FullEventDataSource fullEventsDataSource;

    public FullEventRepositoryImpl(FullEventDataSource fullEventRepository) {
        this.fullEventsDataSource = fullEventRepository;
    }


    @Override
    public void loadEvent(Carry<Event> carry,  String id) {
        fullEventsDataSource.getEvent(carry, id);
    }

    @Override
    public void getTags(Carry<List<Tag>> carry) {
        fullEventsDataSource.getTags(carry);
    }

    @Override
    public void assignEvent(AssignEvent assignEvent, Carry<Event> carry) {
        fullEventsDataSource.assignEvent(assignEvent, carry);
    }
}
