package com.syberianguys.srggrch.eventsgaring.features.event.assigned.presenter;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.domain.AssignInteractor;
import com.syberianguys.srggrch.eventsgaring.features.event.my.domain.MyEventsInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class AssignedPresenter extends MvpPresenter<AssignedView>{
    private final AssignInteractor asEventsInteractor;


    public AssignedPresenter(AssignInteractor asEventsInteractor) {
        this.asEventsInteractor = asEventsInteractor;
    }
    public void getAssignedEvents(){
        view.showProgress();
        String userHost = asEventsInteractor.getUserHost();
        asEventsInteractor.getMyEvents(userHost, new Carry<List<Event>>() {
            @Override
            public void onSuccess(List<Event> result) {
                view.showEventList(result);
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.toString());
            }
        });
    }
    public void onRefresh(){
        getAssignedEvents();
    }
    @Override
    protected void onViewReady() {
        getAssignedEvents();
    }
}
