package com.syberianguys.srggrch.eventsgaring.features.event.my.presenter;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.my.domain.MyEventsInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class MyEventsPresenter extends MvpPresenter<MyEventsView> {

    private final MyEventsInteractor myEventsInteractor;


    public MyEventsPresenter(MyEventsInteractor myEventsInteractor) {
        this.myEventsInteractor = myEventsInteractor;
    }
    public void getMyEvents(){
        view.showProgress();
        String userHost = myEventsInteractor.getUserHost();
        myEventsInteractor.getMyEvents(userHost, new Carry<List<Event>>() {
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
        getMyEvents();
    }
    @Override
    protected void onViewReady() {
        getMyEvents();
    }
}
