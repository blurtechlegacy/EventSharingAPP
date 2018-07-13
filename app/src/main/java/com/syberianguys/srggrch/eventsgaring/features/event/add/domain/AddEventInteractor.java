package com.syberianguys.srggrch.eventsgaring.features.event.add.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface AddEventInteractor {
    void addEvent(Event event, Carry<Event> carry);

    void addTag(Carry<List<Tag>> carry);
    User getUser();


}
