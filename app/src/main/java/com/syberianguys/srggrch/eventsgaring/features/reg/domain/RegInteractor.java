package com.syberianguys.srggrch.eventsgaring.features.reg.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface RegInteractor {
    void addUser(User user, Carry<User> carry);
}
