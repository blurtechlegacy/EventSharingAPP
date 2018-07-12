package com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public interface AuthInteractor {

    void checkAuth (UserAuth userAuth, Carry<User> carry);

    void putUser (User user);

    void putIsAuth (boolean isAuth);

}
