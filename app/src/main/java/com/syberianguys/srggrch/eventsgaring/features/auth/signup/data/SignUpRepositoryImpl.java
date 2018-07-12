package com.syberianguys.srggrch.eventsgaring.features.auth.signup.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

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
