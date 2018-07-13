package com.syberianguys.srggrch.eventsgaring.features.event.list.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public interface ListLocalRepository {
    boolean isAuth();

    User getUser();

    void remove();
}
