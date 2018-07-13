package com.syberianguys.srggrch.eventsgaring.features.event.list.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListRepository;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.localstorage.ListLocalRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public final class ListInteractorImpl implements ListInteractor {
    private final ListRepository listRepository;
    private final ListLocalRepository localRepository;

    public ListInteractorImpl(ListRepository listRepository, ListLocalRepository localRepository) {
        this.listRepository = listRepository;
        this.localRepository = localRepository;
    }

    @Override
    public void loadSearchEvents(String searchString,Carry<List<Event>> carry) {
            listRepository.loadSearchingEvents(searchString,carry);
    }

    @Override
    public void loadEvents(Carry<List<Event>> carry) {
        listRepository.loadEvents(carry);
    }

    @Override
    public boolean isAuth() {
        return localRepository.isAuth();
    }

    @Override
    public User getUser() {
        return localRepository.getUser();
    }

    @Override
    public void removePref() {
        localRepository.remove();
    }
}
