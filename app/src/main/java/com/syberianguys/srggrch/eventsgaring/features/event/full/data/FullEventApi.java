package com.syberianguys.srggrch.eventsgaring.features.event.full.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FullEventApi {
    @GET ("events/{id}")
    Call<Wrapper<Event>> getEvent(@Path("id") String id);

    @POST ("events/assign")
    Call<Wrapper<Event>> assignEvents(@Body AssignEvent assignEvent);
}
