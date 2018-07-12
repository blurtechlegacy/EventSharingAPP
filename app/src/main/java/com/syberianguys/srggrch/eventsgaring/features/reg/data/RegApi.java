package com.syberianguys.srggrch.eventsgaring.features.reg.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegApi {
    @POST("users")
    Call<Wrapper<User>> createUser(@Body User user);
}
