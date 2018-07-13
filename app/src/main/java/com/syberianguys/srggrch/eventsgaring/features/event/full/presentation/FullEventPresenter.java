package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.FullEventInteracor;
import com.syberianguys.srggrch.eventsgaring.features.event.full.domain.model.AssignEvent;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class FullEventPresenter extends MvpPresenter<FullActivityView> {

    private final FullEventInteracor fullEventInteracor;
    private String id;

    public FullEventPresenter(FullEventInteracor fullEventInteracor) {
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
                if ((result.getGuests() != null)&&(result.getGuests().contains(fullEventInteracor.getUserId()))) view.assignDone();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        }, id);
    }


    private void loadEvent(String id) {
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

    public void onWantToGoClicked(String id) {
        view.showProgress();
        fullEventInteracor.assignEvent(new AssignEvent(fullEventInteracor.getUserId(), id), new Carry<Event>() {
            @Override
            public void onSuccess(Event result) {
                view.hideProgress();
                view.assignDone();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.assignFailed();
            }
        });
    }

    void onEventSelected(String id) {
        this.id = id;

    }

}
