package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public interface AuthLocalDataSource {
    void putUserData(User user);
    User getUserData();
    void putIsAuth(boolean isAuth);
    void putBoolean(String key, boolean value);
    void putString(String key, String value);
}
