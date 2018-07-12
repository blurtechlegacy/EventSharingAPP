package com.syberianguys.srggrch.eventsgaring.features.event.list.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.list.domain.ListInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public class EventListPresenter extends MvpPresenter<EventListView>{
    private ListInteractor listInteractor;
    private String searchString;

    public EventListPresenter(ListInteractor listInteractor) {
        this.listInteractor = listInteractor;
    }

    @Override
    protected void onViewReady() {
        loadEvents();
    }

    private void loadEvents(){
        view.showProgress();
        listInteractor.loadEvents(new Carry<List<Event>>() {
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
    public void onEventSelected(Event event){
        //Full Description
    }
    //searching methods
    public void startSearching(){
       listInteractor.loadSearchEvents(searchString, new Carry<List<Event>>() {
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
    public void onSearchedTextChanged(String searchString){
        this.searchString = searchString;
        if(this.searchString.equals("")) loadEvents();
        else startSearching();
    }
}
