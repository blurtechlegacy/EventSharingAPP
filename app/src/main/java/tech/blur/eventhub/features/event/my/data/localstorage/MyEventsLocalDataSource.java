package tech.blur.eventhub.features.event.my.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

public interface MyEventsLocalDataSource {
    String getUserHost();
    String getString(String key);
}
