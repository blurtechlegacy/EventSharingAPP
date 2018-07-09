package com.syberianguys.srggrch.eventsgaring.features.event.full.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface FullEventInteracor {

    void loadEvent(Carry<Event> carry, String id);

}
