package tech.blur.eventhub.features.event.assigned.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.Wrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AssignedApi {
    @GET("events/assigned/{id}")
    Call<Wrapper<List<Event>>> getAssignEventsList(@Path("id")String id);
}
