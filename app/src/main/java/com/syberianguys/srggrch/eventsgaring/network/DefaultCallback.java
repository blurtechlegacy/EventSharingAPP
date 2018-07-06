package com.syberianguys.srggrch.eventsgaring.network;

import com.syberianguys.srggrch.eventsgaring.exception.EmptyBodyException;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class  DefaultCallback<T> implements Callback<Wrapper<T>> {

    private final Carry<T> carry;

    public DefaultCallback(final Carry<T> carry) {
        this.carry = carry;
    }

    @Override
    public void onResponse(Call<Wrapper<T>> call, Response<Wrapper<T>> response) {
        Wrapper<T> wrapper = response.body();
        if (wrapper != null) {
            carry.onSuccess(wrapper.getData());
        } else {
            carry.onFailure(new EmptyBodyException());
        }
    }

    @Override
    public void onFailure(Call<Wrapper<T>> call, Throwable t) {
        carry.onFailure(t);
    }

}