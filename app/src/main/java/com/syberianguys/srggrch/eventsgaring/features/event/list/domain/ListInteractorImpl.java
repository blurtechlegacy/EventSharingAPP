package com.syberianguys.srggrch.eventsgaring.features.event.list.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.list.data.ListRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public final class ListInteractorImpl implements ListInteractor {
    private final ListRepository listRepository;

    public ListInteractorImpl(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public void loadSearchEvents(String searchString,Carry<List<Event>> carry) {
            listRepository.loadSearchingEvents(searchString,carry);
    }

    @Override
    public void loadEvents(Carry<List<Event>> carry) {
        listRepository.loadEvents(carry);
    }
}
