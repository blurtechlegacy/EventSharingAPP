package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface AuthInteractor {

    void loadUser(String id, Carry<User> carry);

    void checkAuth (UserAuth userAuth, Carry<UserAuth> carry);

}
