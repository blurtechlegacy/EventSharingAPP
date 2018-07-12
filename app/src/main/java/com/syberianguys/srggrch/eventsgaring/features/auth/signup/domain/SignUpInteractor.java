package com.syberianguys.srggrch.eventsgaring.features.auth.signup.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface SignUpInteractor {
    void addUser(User user, Carry<User> carry);
}
