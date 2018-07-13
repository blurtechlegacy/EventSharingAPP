package com.syberianguys.srggrch.eventsgaring.features.event.my.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

import java.util.List;

public class MyEventsDataSourceImpl implements MyEventsDataSource{
    private final MyEventsApi myEventsApi;

    public MyEventsDataSourceImpl(MyEventsApi myEventsApi) {
        this.myEventsApi = myEventsApi;
    }

    @Override
    public void getMyEvents(String userHost, Carry<List<Event>> carry) {
        myEventsApi.getMyEventsList(userHost).enqueue(new DefaultCallback(carry));
    }
}
