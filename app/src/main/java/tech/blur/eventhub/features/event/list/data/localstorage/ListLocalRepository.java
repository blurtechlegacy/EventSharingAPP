package tech.blur.eventhub.features.event.list.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

public interface ListLocalRepository {
    boolean isAuth();

    User getUser();

    void remove();
}
