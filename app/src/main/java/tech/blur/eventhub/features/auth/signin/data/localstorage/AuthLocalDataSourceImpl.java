package tech.blur.eventhub.features.auth.signin.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import tech.blur.eventhub.R;
import tech.blur.eventhub.features.core.events.model.User;

import tech.blur.eventhub.features.core.events.model.User;

public class AuthLocalDataSourceImpl implements AuthLocalDataSource {
    private SharedPreferences sharedPreferences;

    public AuthLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(tech.blur.eventhub.R.string.auth_settings_key),
                Context.MODE_PRIVATE);
    }

    @Override
    public void putString(String key, String value) {
       SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putString(key, value);
       editor.apply();
    }


    @Override
    public void putUserData(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        putString("userData", json);
        User users = getUserData();

    }
    public String getString(String key) {
        return sharedPreferences.getString("userData", null);
    }


    @Override
    public User getUserData() {
        Gson gson = new Gson();
        String json = getString("userData");
        User user = gson.fromJson(json, User.class);

        return user;
    }

    @Override
    public void putIsAuth(boolean isAuth) {
        putBoolean("isAuth", isAuth);

    }

    @Override
    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
