package com.syberianguys.srggrch.eventsgaring.features.event.full.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.full.data.FullEventRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class FullEventInteracorImpl implements FullEventInteracor {

    private final FullEventRepository fullEventRepository;

    public FullEventInteracorImpl(FullEventRepository fullEventRepository) {
        this.fullEventRepository = fullEventRepository;
    }

    @Override
    public void loadEvent(Carry<Event> carry, String id) {
        fullEventRepository.loadEvent(carry, id);
    }
}
