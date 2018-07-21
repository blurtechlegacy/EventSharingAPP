package tech.blur.eventhub.features.auth.signup.data;

import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.core.events.model.User;

public interface SignUpRepository {
    void addUser(User user, Carry<User> carry);
}
