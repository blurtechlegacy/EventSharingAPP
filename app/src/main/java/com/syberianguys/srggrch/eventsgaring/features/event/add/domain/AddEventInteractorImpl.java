package com.syberianguys.srggrch.eventsgaring.features.event.add.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.AddEventRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.add.data.localstorage.AddEventLocalRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class AddEventInteractorImpl implements AddEventInteractor {
    private final AddEventRepository addEventRepository;
    private final AddEventLocalRepository localRepository;

    public AddEventInteractorImpl(AddEventRepository addEventRepository, AddEventLocalRepository localRepository) {
        this.addEventRepository = addEventRepository;
        this.localRepository = localRepository;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventRepository.addEvent(event, carry);
    }

    @Override
    public void addTag(Carry<List<Tag>> carry) {
        addEventRepository.addTags(carry);
    }


    @Override
    public User getUser() {
        return localRepository.getUser();
    }
}
