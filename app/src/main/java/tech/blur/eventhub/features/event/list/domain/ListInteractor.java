package tech.blur.eventhub.features.event.list.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public interface ListInteractor {
    void loadSearchEvents (String searchString,Carry<List<Event>> carry);
    void loadEvents(Carry<List<Event>>  carry);
    boolean isAuth();
    User getUser();
    void removePref();
}
