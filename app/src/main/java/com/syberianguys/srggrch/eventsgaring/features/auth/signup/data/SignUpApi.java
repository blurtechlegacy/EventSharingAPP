package com.syberianguys.srggrch.eventsgaring.features.auth.signup.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpApi {
    @POST("users")
    Call<Wrapper<User>> createUser(@Body User user);
}
