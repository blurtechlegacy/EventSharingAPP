package com.syberianguys.srggrch.eventsgaring.features.event.my.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface MyEventsInteractor {
    void getMyEvents(String userHost,Carry<List<Event>> carry);
    String getUserHost();
}
