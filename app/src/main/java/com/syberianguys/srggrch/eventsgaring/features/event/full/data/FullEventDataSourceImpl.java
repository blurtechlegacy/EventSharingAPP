package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

public final class FullEventDataSourceImpl implements FullEventDataSource {
    private final FullEventApi eventApi;

    public FullEventDataSourceImpl(FullEventApi eventApi) {
        this.eventApi = eventApi;
    }

    @Override
    public void getEvent(Carry<Event> carry, String id) {
        eventApi.getEvent(id).enqueue(new DefaultCallback(carry));
    }
}
