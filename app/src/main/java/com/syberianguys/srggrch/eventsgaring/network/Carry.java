package com.syberianguys.srggrch.eventsgaring.network;

public interface Carry<T> {
    void onSuccess(T result);

    void onFailure(Throwable throwable);
}
