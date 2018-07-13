package com.syberianguys.srggrch.eventsgaring.features.event.assigned.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface AssignInteractor  {
    void getMyEvents(String userHost,Carry<List<Event>> carry);
    String getUserHost();
}
