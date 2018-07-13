package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListApi;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

import retrofit2.Call;

public interface FullEventDataSource {
    void getEvent(Carry<Event> carry, String id);

    void getTags(Carry<List<Tag>> carry);

    void assignEvent (AssignEvent assignEvent, Carry<Event> carry);
}
