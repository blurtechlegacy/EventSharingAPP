package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

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
    public void assignEvent(AssignEvent assignEvent, Carry<Event> carry) {
        fullEventsDataSource.assignEvent(assignEvent, carry);
    }
}
