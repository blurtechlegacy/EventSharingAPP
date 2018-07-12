package com.syberianguys.srggrch.eventsgaring.features.event.list.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface ListRepository {
    void loadSearchingEvents (String searchString,Carry<List<Event>> carry);

    void loadEvents(Carry<List<Event>> carry);
}
