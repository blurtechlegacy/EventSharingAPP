package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.FullEventInteracor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class FullEventPresenter extends MvpPresenter<FullActivityView> {

    private final FullEventInteracor fullEventInteracor;
    private String id;

    private FullEventPresenter(FullEventInteracor fullEventInteracor) {
        this.fullEventInteracor = fullEventInteracor;
    }

    @Override
    protected void onViewReady() {
        view.showProgress();
        fullEventInteracor.loadEvent(new Carry<Event>() {
            @Override
            public void onSuccess(Event result) {
                view.hideProgress();
                view.showEvent(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        }, id);
    }
    private void loadEvent(String id){
        view.showProgress();
        fullEventInteracor.loadEvent(new Carry<Event>() {

            @Override
            public void onSuccess(Event result) {
                view.showEvent(result);
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.toString());
                view.hideProgress();
            }
        }, id);
    }

    void onEventSelected(String id){
        this.id = id;

    }

}
