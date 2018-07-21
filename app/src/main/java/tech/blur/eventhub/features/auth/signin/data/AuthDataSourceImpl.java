package tech.blur.eventhub.features.auth.signin.data;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public class AuthDataSourceImpl implements AuthDataSource {

    final private AuthApi authApi;

    public AuthDataSourceImpl(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<User> carry) {
        authApi.CheckUser(userAuth).enqueue(new DefaultCallback(carry));
    }
}
