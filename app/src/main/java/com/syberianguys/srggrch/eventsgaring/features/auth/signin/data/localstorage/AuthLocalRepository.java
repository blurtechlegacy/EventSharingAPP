package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public interface AuthLocalRepository {
    void putUserData(User user);
    User getUserData ();
    void putIsAuth(boolean isAuth);
}
