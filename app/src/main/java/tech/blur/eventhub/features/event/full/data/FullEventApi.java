package tech.blur.eventhub.features.event.full.data;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.Wrapper;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public interface FullEventApi {
    @GET ("events/{id}")
    Call<Wrapper<Event>> getEvent(@Path("id") String id);

    @GET ("tags")
    Call<Wrapper<List<Tag>>> getTags();

    @POST ("events/assign")
    Call<Wrapper<Event>> assignEvents(@Body AssignEvent assignEvent);
}
