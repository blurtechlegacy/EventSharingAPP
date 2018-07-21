package tech.blur.eventhub.features.auth.signin.data;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public class AuthRepositoryImpl implements AuthRepository {
    private final AuthDataSource authDataSource;

    public AuthRepositoryImpl(AuthDataSource authDataSource) {
        this.authDataSource = authDataSource;
    }

    @Override
    public void auth(UserAuth userAuth, Carry<User> carry) {
        authDataSource.checkAuth(userAuth, carry);
    }
}
