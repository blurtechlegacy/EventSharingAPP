package tech.blur.eventhub.features.event.list.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

public interface ListLocalDataSource {
    boolean isAuth();

    User getUser();

    String getString(String key);

    void remove_prefernces();

}
