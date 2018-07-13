package com.syberianguys.srggrch.eventsgaring.features.event.list.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface ListInteractor {
    void loadSearchEvents (String searchString,Carry<List<Event>> carry);
    void loadEvents(Carry<List<Event>>  carry);
    boolean isAuth();
    User getUser();
}
