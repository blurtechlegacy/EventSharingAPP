package com.syberianguys.srggrch.eventsgaring.features.event.add.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AddEventApi {
    @POST("events")
    Call<Wrapper<Event>> createEvent(@Body Event event);
}
