package com.syberianguys.srggrch.eventsgaring.features.event.full.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface FullEventInteracor {

    void loadEvent(Carry<Event> carry, String id);

    void getTags(Carry<List<Tag>> carry);

    void assignEvent (AssignEvent assignEvent, Carry<Event> carry);

    String getUserId();

}
