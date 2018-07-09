package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import retrofit2.Call;

public interface FullEventDataSource {
    void getEvent(Carry<Event> carry, String id);
}
