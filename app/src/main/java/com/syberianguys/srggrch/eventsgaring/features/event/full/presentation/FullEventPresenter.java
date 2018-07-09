package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.FullEventInteracor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class FullEventPresenter extends MvpPresenter<FullActivityView> {

    private final FullEventInteracor fullEventInteracor;

    public FullEventPresenter(FullEventInteracor fullEventInteracor) {
        this.fullEventInteracor = fullEventInteracor;
    }

    @Override
    protected void onViewReady() {

    }
    private void loadEvent(String id){
        fullEventInteracor.loadEvent(new Carry<Event>() {
            @Override
            public void onSuccess(Event result) {
                view.showEvent(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.toString());
            }
        }, id);
    }

    void onEventSelected(String id){
        fullEventInteracor.loadEvent(new Carry<Event>() {
            @Override
            public void onSuccess(Event result) {
                view.showEvent(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        }, id);
    }

}
