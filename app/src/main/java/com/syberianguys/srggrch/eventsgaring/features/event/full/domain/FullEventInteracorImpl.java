package com.syberianguys.srggrch.eventsgaring.features.event.full.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage.FullEventLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class FullEventInteracorImpl implements FullEventInteracor {

    private final FullEventRepository fullEventRepository;
    private final FullEventLocalRepository fullEventLocalRepository;

    public FullEventInteracorImpl(FullEventRepository fullEventRepository, FullEventLocalRepository fullEventLocalRepository) {
        this.fullEventRepository = fullEventRepository;
        this.fullEventLocalRepository = fullEventLocalRepository;
    }

    @Override
    public void loadEvent(Carry<Event> carry, String id) {
        fullEventRepository.loadEvent(carry, id);
    }

    @Override
    public void assignEvent(AssignEvent assignEvent, Carry<Event> carry) {
        fullEventRepository.assignEvent(assignEvent, carry);
    }

    @Override
    public String getUserId() {
        return fullEventLocalRepository.getUserId();
    }

}
