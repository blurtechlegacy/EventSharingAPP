package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface FullEventRepository {
    void loadEvent(Carry<Event> carry, String id);

    void assignEvent (AssignEvent assignEvent, Carry<Event> carry);
}
