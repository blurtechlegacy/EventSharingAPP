package tech.blur.eventhub.features.event.assigned.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import tech.blur.eventhub.R;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.assigned.data.AssignedDataSource;
import tech.blur.eventhub.network.Carry;

import java.util.List;

public class AssignedLocalDataSourceImpl implements AssignedLocalDataSource {
    private SharedPreferences sharedPreferences;

    public AssignedLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(tech.blur.eventhub.R.string.auth_settings_key),Context.MODE_PRIVATE);
    }



    @Override
    public String getUserHost() {
        Gson gson = new Gson();
        String json = getString("userData");
        User user = gson.fromJson(json,User.class);
        return user.getId();
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }
}
