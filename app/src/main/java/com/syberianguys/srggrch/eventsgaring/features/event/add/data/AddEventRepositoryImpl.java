package com.syberianguys.srggrch.eventsgaring.features.event.add.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class AddEventRepositoryImpl implements AddEventRepository {

    private final AddEventDataSource addEventDataSource;

    public AddEventRepositoryImpl(AddEventDataSource addEventDataSource) {
        this.addEventDataSource = addEventDataSource;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventDataSource.addEvent(event,carry);
    }
}
