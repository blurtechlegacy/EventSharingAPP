package tech.blur.eventhub.features.event.assigned.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import java.util.List;

public class AssignedDataSourceImpl implements AssignedDataSource{
    private final AssignedApi asEventsApi;

    public AssignedDataSourceImpl(AssignedApi myEventsApi) {
        this.asEventsApi = myEventsApi;
    }

    @Override
    public void getAssignedEvents(String userHost, Carry<List<Event>> carry) {
        asEventsApi.getAssignEventsList(userHost).enqueue(new DefaultCallback(carry));
    }
}
