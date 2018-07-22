package tech.blur.eventhub.features.auth.signup.domain;

import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.core.events.model.User;

public interface SignUpInteractor {
    void addUser(User user, Carry<User> carry);
}
