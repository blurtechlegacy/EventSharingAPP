package com.syberianguys.srggrch.eventsgaring.features.event.assigned.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface AssignedRepository {
    void getAssignedEventsList(String userHost,Carry<List<Event>> carry) ;
}
