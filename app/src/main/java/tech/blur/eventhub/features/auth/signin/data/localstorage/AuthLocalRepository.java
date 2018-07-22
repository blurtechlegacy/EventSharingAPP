package tech.blur.eventhub.features.auth.signin.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

import tech.blur.eventhub.features.core.events.model.User;

public interface AuthLocalRepository {
    void putUserData(User user);
    User getUserData ();
    void putIsAuth(boolean isAuth);
}
