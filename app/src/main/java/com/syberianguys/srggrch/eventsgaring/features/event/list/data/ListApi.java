package com.syberianguys.srggrch.eventsgaring.features.event.list.data;

import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Wrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListApi  {
    @GET ("events/search/{name}")
    Call<Wrapper<List<Event>>> getSearchEventList(@Path("name")String name);
    @GET ("events")
    Call<Wrapper<List<Event>>> getEventList();
}
