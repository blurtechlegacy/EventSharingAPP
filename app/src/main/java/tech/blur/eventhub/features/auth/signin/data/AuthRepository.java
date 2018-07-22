package tech.blur.eventhub.features.auth.signin.data;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public interface AuthRepository {

    void auth(UserAuth userAuth, Carry<User> carry);

}
