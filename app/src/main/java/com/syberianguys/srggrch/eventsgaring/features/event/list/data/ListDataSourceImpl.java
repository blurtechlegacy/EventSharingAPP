package com.syberianguys.srggrch.eventsgaring.features.event.list.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

import java.util.List;

public final class ListDataSourceImpl implements ListDataSource {

    private final ListApi listApi;

    public ListDataSourceImpl(ListApi listApi) {
        this.listApi = listApi;
    }

    @Override
    public void getSearchEvents(String searchString,Carry<List<Event>> carry) {
        listApi.getSearchEventList(searchString).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void getEvents(Carry<List<Event>> carry) {
        listApi.getEventList().enqueue(new DefaultCallback(carry));
    }

}
