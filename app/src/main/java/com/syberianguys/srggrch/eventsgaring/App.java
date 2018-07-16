package com.syberianguys.srggrch.eventsgaring;

import android.app.Application;
import android.content.Context;

import com.instabug.library.*;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.syberianguys.srggrch.eventsgaring.network.RetrofitProvider;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public final class App extends Application {

    private RetrofitProvider retrofitProvider;

    public static RetrofitProvider getRetrofitProvider(Context context) {
        return getApp(context).retrofitProvider;
    }

    private static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Instabug.Builder(this, "0fbdb3542cbb2a25dd77b7cd2fe75d78")
                .setInvocationEvents(InstabugInvocationEvent.SHAKE, InstabugInvocationEvent.SCREENSHOT_GESTURE)
                .build();
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder("2558d53e-c378-4b51-bf07-c95d8342c231");
        YandexMetrica.activate(getApplicationContext(), configBuilder.build());
        YandexMetrica.enableActivityAutoTracking(this);
        retrofitProvider = new RetrofitProvider();
    }
}
