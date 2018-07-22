package tech.blur.eventhub.features.event.add.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import java.util.List;

import tech.blur.eventhub.features.event.add.presentation.Tag;

public class AddEventDataSourceImpl implements AddEventDataSource {
    private final AddEventApi addEventApi;

    public AddEventDataSourceImpl(AddEventApi addEventApi) {
        this.addEventApi = addEventApi;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventApi.createEvent(event).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void getTags(Carry<List<Tag>> carry) {
        addEventApi.getTagList().enqueue(new DefaultCallback<List<Tag>>(carry));
    }



}
