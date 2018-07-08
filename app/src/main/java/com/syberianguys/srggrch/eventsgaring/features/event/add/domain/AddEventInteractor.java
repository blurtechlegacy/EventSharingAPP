package com.syberianguys.srggrch.eventsgaring.features.event.add.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface AddEventInteractor {
    void addEvent(Event event, Carry<Event> carry);



}
