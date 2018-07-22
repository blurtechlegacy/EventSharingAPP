package tech.blur.eventhub.features.auth.signup.data;

import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.core.events.model.Wrapper;

public interface SignUpApi {
    @POST("users")
    Call<Wrapper<User>> createUser(@Body User user);
}
