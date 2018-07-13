package com.syberianguys.srggrch.eventsgaring.features.event.my.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface MyEventsDataSource {
   void getMyEvents (String userHost, Carry<List<Event>> carry);
}
