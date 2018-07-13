package com.syberianguys.srggrch.eventsgaring.features.event.my.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class MyEventsRepositoryImpl implements MyEventsRepository {
    private final MyEventsDataSource myEventsDataSource;

    public MyEventsRepositoryImpl(MyEventsDataSource myEventsDataSource) {
        this.myEventsDataSource = myEventsDataSource;
    }


    @Override
    public void getMyEventsList(String userHost,Carry<List<Event>> carry) {
        myEventsDataSource.getMyEvents(userHost,carry);
    }
}
