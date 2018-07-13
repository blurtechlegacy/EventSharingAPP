package com.syberianguys.srggrch.eventsgaring.features.event.my.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public interface MyEventsLocalDataSource {
    String getUserHost();
    String getString(String key);
}
