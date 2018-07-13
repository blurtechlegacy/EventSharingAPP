package com.syberianguys.srggrch.eventsgaring.features.event.assigned.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class AssignedRepositoryImpl implements AssignedRepository {
    private final AssignedDataSource assignEventsDataSource;

    public AssignedRepositoryImpl(AssignedDataSource assignedDataSource) {
        this.assignEventsDataSource = assignedDataSource;
    }


    @Override
    public void getAssignedEventsList(String userHost, Carry<List<Event>> carry) {
        assignEventsDataSource.getAssignedEvents(userHost,carry);
    }
}
