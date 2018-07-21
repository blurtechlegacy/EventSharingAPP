package tech.blur.eventhub.features.event.list.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import tech.blur.eventhub.R;
import tech.blur.eventhub.features.core.events.model.User;

public class ListLocalDataSourceImpl implements ListLocalDataSource {
    private SharedPreferences sharedPreferences;

    public ListLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(tech.blur.eventhub.R.string.auth_settings_key),
                Context.MODE_PRIVATE);
    }

    @Override
    public boolean isAuth() {
        return sharedPreferences.getBoolean("isAuth", false);
    }

    @Override
    public User getUser() {
        Gson gson = new Gson();
        String json = getString("userData");
        User user = gson.fromJson(json, User.class);

        return user;
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    @Override
    public void remove_prefernces() {
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.clear();
       editor.putBoolean("isAuth", false);
        editor.remove("userData");
        editor.commit();
    }
}
