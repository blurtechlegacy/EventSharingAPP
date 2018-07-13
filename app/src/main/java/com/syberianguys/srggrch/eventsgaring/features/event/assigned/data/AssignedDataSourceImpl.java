package com.syberianguys.srggrch.eventsgaring.features.event.assigned.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

import java.util.List;

public class AssignedDataSourceImpl implements AssignedDataSource{
    private final AssignedApi asEventsApi;

    public AssignedDataSourceImpl(AssignedApi myEventsApi) {
        this.asEventsApi = myEventsApi;
    }

    @Override
    public void getAssignedEvents(String userHost, Carry<List<Event>> carry) {
        asEventsApi.getAssignEventsList(userHost).enqueue(new DefaultCallback(carry));
    }
}
