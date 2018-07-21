package tech.blur.eventhub.features.event.full.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import tech.blur.eventhub.R;
import tech.blur.eventhub.features.core.events.model.User;

public class FullEventLocalDataSourceImpl implements FullEventLocalDataSource {


    private SharedPreferences sharedPreferences;

    public FullEventLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(tech.blur.eventhub.R.string.auth_settings_key),
                Context.MODE_PRIVATE);
    }

    @Override
    public String getUserId() {
        Gson gson = new Gson();
        String json = getString("userData");
        User user = gson.fromJson(json, User.class);

        return user.getId();
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString("userData", null);
    }

}
