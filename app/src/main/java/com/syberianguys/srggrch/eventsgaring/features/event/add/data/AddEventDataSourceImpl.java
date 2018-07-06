package com.syberianguys.srggrch.eventsgaring.features.event.add.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class AddEventDataSourceImpl implements AddEventDataSource {
    private final AddEventApi addEventApi;

    public AddEventDataSourceImpl(AddEventApi addEventApi) {
        this.addEventApi = addEventApi;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventApi.createEvent(event);
    }
}
