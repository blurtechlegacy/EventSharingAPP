package com.syberianguys.srggrch.eventsgaring.features.event.list.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface ListDataSource {
    void getSearchEvents(String searchString, Carry<List<Event>> carry);
    void getEvents(Carry<List<Event>> carry);
}
