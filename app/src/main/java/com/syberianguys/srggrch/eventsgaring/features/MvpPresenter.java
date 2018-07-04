package com.syberianguys.srggrch.eventsgaring.features;

public class MvpPresenter <View extends MvpView>{
    protected View view;

    public void attachView(View view) {
        this.view = view;
        onViewReady();
    }

    public void detachView() {
        view = null;
    }

    @SuppressWarnings("WeakerAccess")
    protected void onViewReady() {
        // override if need
    }
}
