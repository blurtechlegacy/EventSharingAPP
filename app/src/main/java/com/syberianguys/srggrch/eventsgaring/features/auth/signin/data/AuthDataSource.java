package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface AuthDataSource {
    void checkAuth (UserAuth userAuth, Carry<UserAuth> carry);

    void getUser(String id, Carry<User> carry);
}
