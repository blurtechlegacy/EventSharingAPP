package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;

import java.util.ArrayList;
import java.util.List;

public interface FullActivityView extends MvpView {

    void showProgress();

    void hideProgress();

    void showEvent(Event event, List<Tag> tags);

    void showError(String message);

    void assignFailed();

    void assignDone();
}
