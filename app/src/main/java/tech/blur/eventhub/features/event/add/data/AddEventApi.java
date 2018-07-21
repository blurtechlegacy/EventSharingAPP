package tech.blur.eventhub.features.event.add.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.Wrapper;
import tech.blur.eventhub.features.event.add.presentation.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tech.blur.eventhub.features.event.add.presentation.Tag;

public interface AddEventApi {
    @POST("events")
    Call<Wrapper<Event>> createEvent(@Body Event event);

    @GET("tags")
    Call<Wrapper<List<Tag>>> getTagList();
}
