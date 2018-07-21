package tech.blur.eventhub.features.auth.signup.data;

import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.core.events.model.User;

public class SignUpRepositoryImpl implements SignUpRepository {
    SignUpDataSource signUpDataSource;

    public SignUpRepositoryImpl(SignUpDataSource signUpDataSource) {
        this.signUpDataSource = signUpDataSource;
    }

    @Override
    public void addUser(User user, Carry<User> carry) {
        signUpDataSource.addUser(user,carry);
    }
}
