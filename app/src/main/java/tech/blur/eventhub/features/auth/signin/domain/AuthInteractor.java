package tech.blur.eventhub.features.auth.signin.domain;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public interface AuthInteractor {

    void checkAuth (UserAuth userAuth, Carry<User> carry);

    void putUser (User user);

    void putIsAuth (boolean isAuth);

}
