package tech.blur.eventhub.features.event.add.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.add.presentation.Tag;

public class AddEventRepositoryImpl implements AddEventRepository {

    private final AddEventDataSource addEventDataSource;

    public AddEventRepositoryImpl(AddEventDataSource addEventDataSource) {
        this.addEventDataSource = addEventDataSource;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventDataSource.addEvent(event,carry);
    }

    @Override
    public void addTags(Carry<List<Tag>> carry) {
        addEventDataSource.getTags(carry);
    }
}
