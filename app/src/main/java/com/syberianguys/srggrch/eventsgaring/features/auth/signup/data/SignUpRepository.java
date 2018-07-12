package com.syberianguys.srggrch.eventsgaring.features.auth.signup.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface SignUpRepository {
    void addUser(User user, Carry<User> carry);
}
