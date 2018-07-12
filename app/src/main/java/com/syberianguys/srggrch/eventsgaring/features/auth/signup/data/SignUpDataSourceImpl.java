package com.syberianguys.srggrch.eventsgaring.features.auth.signup.data;


import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

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
