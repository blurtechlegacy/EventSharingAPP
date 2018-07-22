package tech.blur.eventhub.features.event.list.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public final class ListRepositoryImpl implements ListRepository {
    private final ListDataSource listDataSource;

    public ListRepositoryImpl(ListDataSource listDataSource) {
        this.listDataSource = listDataSource;
    }

    @Override
    public void loadSearchingEvents(String searchString,Carry<List<Event>> carry) {
        listDataSource.getSearchEvents(searchString,carry);
    }

    @Override
    public void loadEvents(Carry<List<Event>> carry) {
        listDataSource.getEvents(carry);
    }
}
