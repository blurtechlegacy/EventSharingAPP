package tech.blur.eventhub.features.event.list.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

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
