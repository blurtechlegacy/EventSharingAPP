package com.syberianguys.srggrch.eventsgaring.features.event.list.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.List;

public interface EventListView extends MvpView{
    void showProgress();

    void hideProgress();

    void showEventList(List<Event> list);

    void showError(String message);
}
