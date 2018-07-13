package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.List;

public interface AddEventView extends MvpView {
    void showProgress();

    void hideProgress();

    void dateEmptyError();

    void showError(String message);

    void showTagList(List<Tag> list);
}
