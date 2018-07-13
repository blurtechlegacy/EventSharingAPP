package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;

public interface AddEventView extends MvpView {
    void showProgress();

    void hideProgress();

    void dateEmptyError();

    void showError(String message);
}
