package com.syberianguys.srggrch.eventsgaring.features.event.list.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public interface ListLocalDataSource {
    boolean isAuth();

    User getUser();

    String getString(String key);

}
