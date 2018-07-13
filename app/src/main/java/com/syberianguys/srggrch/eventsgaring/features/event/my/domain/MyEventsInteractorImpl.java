package com.syberianguys.srggrch.eventsgaring.features.event.my.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class MyEventsInteractorImpl implements MyEventsInteractor{

    private final MyEventsRepository myEventsRepository;
    private final MyEventsLocalRepository myEventsLocalRepository;

    public MyEventsInteractorImpl(MyEventsRepository myEventsRepository, MyEventsLocalRepository myEventsLocalRepository) {
        this.myEventsRepository = myEventsRepository;
        this.myEventsLocalRepository = myEventsLocalRepository;
    }


    @Override
    public void getMyEvents(String userHost, Carry<List<Event>> carry) {
        myEventsRepository.getMyEventsList(userHost,carry);
    }

    @Override
    public String getUserHost() {
        return myEventsLocalRepository.getUserHost();
    }

}
