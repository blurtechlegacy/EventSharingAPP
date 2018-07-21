package tech.blur.eventhub.features.event.add.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

public interface AddEventLocalDataSource {
    User getUser();
    String getString(String key);
}
