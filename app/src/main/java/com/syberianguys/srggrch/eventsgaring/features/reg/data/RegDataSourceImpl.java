package com.syberianguys.srggrch.eventsgaring.features.reg.data;


import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;
import com.syberianguys.srggrch.eventsgaring.network.DefaultCallback;

public class RegDataSourceImpl implements RegDataSource{
    private final RegApi regApi;

    public RegDataSourceImpl(RegApi regApi) {
        this.regApi = regApi;
    }


    @Override
    public void addUser(User user, Carry<User> carry) {
        regApi.createUser(user).enqueue(new DefaultCallback<User>(carry));
    }
}
