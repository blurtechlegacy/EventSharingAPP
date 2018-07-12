package com.syberianguys.srggrch.eventsgaring.features.reg.domain;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.reg.data.RegRepository;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class RegInteractorImpl implements RegInteractor {
   private RegRepository repository;

    public RegInteractorImpl(RegRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user, Carry<User> carry) {
        repository.addUser(user,carry);
    }
}
