package tech.blur.eventhub.features.auth.signin.domain;

import tech.blur.eventhub.features.auth.signin.data.AuthRepository;
import tech.blur.eventhub.features.auth.signin.data.localstorage.AuthLocalRepository;
import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public class AuthInteractorImpl implements AuthInteractor {

    private final AuthRepository authRepository;
    private final AuthLocalRepository authLocalRepository;

     public AuthInteractorImpl(AuthRepository authRepository, AuthLocalRepository authLocalRepository) {
        this.authRepository = authRepository;
         this.authLocalRepository = authLocalRepository;
     }

    @Override
    public void checkAuth(UserAuth userAuth, Carry<User> carry) {
        authRepository.auth(userAuth, carry);
    }

    @Override
    public void putUser(User user) {
        authLocalRepository.putUserData(user);

    }

    @Override
    public void putIsAuth(boolean isAuth) {
        authLocalRepository.putIsAuth(isAuth);
    }
}
