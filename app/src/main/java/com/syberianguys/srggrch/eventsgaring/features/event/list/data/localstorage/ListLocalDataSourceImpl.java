package com.syberianguys.srggrch.eventsgaring.features.event.list.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.syberianguys.srggrch.eventsgaring.R;

public class ListLocalDataSourceImpl implements ListLocalDataSource {
    private SharedPreferences sharedPreferences;

    public ListLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.auth_settings_key),
                Context.MODE_PRIVATE);
    }

    @Override
    public boolean isAuth() {
        return sharedPreferences.getBoolean("isAuth", false);
    }
}
