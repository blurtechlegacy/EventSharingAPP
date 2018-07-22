package tech.blur.eventhub.features.auth.signup.data;


import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.network.Carry;
import tech.blur.eventhub.network.DefaultCallback;

import tech.blur.eventhub.features.core.events.model.User;

public class SignUpDataSourceImpl implements SignUpDataSource {
    private final SignUpApi signUpApi;

    public SignUpDataSourceImpl(SignUpApi signUpApi) {
        this.signUpApi = signUpApi;
    }


    @Override
    public void addUser(User user, Carry<User> carry) {
        signUpApi.createUser(user).enqueue(new DefaultCallback<User>(carry));
    }
}
