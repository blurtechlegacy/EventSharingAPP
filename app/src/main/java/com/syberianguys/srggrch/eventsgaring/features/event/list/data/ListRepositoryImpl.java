package com.syberianguys.srggrch.eventsgaring.features.event.list.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public final class ListRepositoryImpl implements ListRepository {
    private final ListDataSource listDataSource;

    public ListRepositoryImpl(ListDataSource listDataSource) {
        this.listDataSource = listDataSource;
    }

    @Override
    public void loadEvents(Carry<List<Event>> carry) {
        listDataSource.getEvents(carry);
    }
}
