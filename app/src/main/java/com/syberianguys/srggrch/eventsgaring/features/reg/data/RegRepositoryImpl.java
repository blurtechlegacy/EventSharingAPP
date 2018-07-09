package com.syberianguys.srggrch.eventsgaring.features.reg.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class RegRepositoryImpl implements RegRepository {
    RegDataSource regDataSource;

    public RegRepositoryImpl(RegDataSource regDataSource) {
        this.regDataSource = regDataSource;
    }

    @Override
    public void addUser(User user, Carry<User> carry) {
        regDataSource.addUser(user,carry);
    }
}
