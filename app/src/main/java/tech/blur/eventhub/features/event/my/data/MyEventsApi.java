package tech.blur.eventhub.features.event.my.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.Wrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyEventsApi {
    @GET("events/byuser/{id}")
    Call<Wrapper<List<Event>>> getMyEventsList(@Path("id")String id);
}
