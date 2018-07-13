package com.syberianguys.srggrch.eventsgaring.features.event.assigned.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.AssignedRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.data.localstorage.AssignedLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.MyEventsRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage.MyEventsLocalRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class AssignInteractorImpl implements AssignInteractor {

    private final AssignedRepository asEventsRepository;
    private final AssignedLocalRepository asEventsLocalRepository;

    public AssignInteractorImpl(AssignedRepository asEventsRepository, AssignedLocalRepository asEventsLocalRepository) {
        this.asEventsRepository = asEventsRepository;
        this.asEventsLocalRepository = asEventsLocalRepository;
    }


    @Override
    public void getMyEvents(String userHost, Carry<List<Event>> carry) {
        asEventsRepository.getAssignedEventsList(userHost,carry);
    }

    @Override
    public String getUserHost() {
        return asEventsLocalRepository.getUserHost();
    }

}
