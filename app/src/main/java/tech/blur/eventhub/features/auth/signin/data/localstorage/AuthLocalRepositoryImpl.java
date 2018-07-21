package tech.blur.eventhub.features.auth.signin.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

import tech.blur.eventhub.features.core.events.model.User;

public class AuthLocalRepositoryImpl implements AuthLocalRepository {
    private final AuthLocalDataSource dataSource;

    public AuthLocalRepositoryImpl(AuthLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void putUserData(User user) {
        dataSource.putUserData(user);
    }

    @Override
    public User getUserData() {
        return null;
    }

    @Override
    public void putIsAuth(boolean isAuth) {
        dataSource.putIsAuth(isAuth);
    }
}
