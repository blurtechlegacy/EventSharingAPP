package com.syberianguys.srggrch.eventsgaring.features.reg.presenter;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;

public interface RegView extends MvpView{
    void showProgress();

    void hideProgress();

    void showError(String message);


}
