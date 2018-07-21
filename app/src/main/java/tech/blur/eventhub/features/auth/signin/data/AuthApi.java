package tech.blur.eventhub.features.auth.signin.data;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.core.events.model.Wrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.Wrapper;

public interface AuthApi {
    @POST("users/auth")
    Call<Wrapper<User>> CheckUser (@Body UserAuth userAuth);

}
