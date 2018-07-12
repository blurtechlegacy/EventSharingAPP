package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;

public class AuthLocalDataSourceImpl implements AuthLocalDataSource {
    private SharedPreferences sharedPreferences;

    public AuthLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.auth_settings_key),
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
    }


    @Override
    public User getUserData() {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = "";
        sharedPreferences.getString("userData", json);
        return null;
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
