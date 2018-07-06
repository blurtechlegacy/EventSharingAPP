package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface AuthDataSource {
    void checkAuth (String login, String pass);

    void getId(String id, Carry<User> carry);
}
