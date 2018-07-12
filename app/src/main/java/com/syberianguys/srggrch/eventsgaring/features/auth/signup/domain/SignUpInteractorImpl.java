package com.syberianguys.srggrch.eventsgaring.features.auth.signup.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.data.SignUpRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class SignUpInteractorImpl implements SignUpInteractor {
   private SignUpRepository repository;

    public SignUpInteractorImpl(SignUpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user, Carry<User> carry) {
        repository.addUser(user,carry);
    }
}
