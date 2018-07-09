package com.syberianguys.srggrch.eventsgaring.features.reg.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface RegDataSource {
    void addUser(User user, Carry<User> carry);
}
