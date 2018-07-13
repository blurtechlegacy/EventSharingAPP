package com.syberianguys.srggrch.eventsgaring.features.event.add.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

import java.util.List;

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
