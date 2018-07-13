package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.ArrayList;

public class AddEventPresenter extends MvpPresenter<AddEventView> {
    private final AddEventInteractor addEventInteractor;

    private String nameEvent;
    private String nameHost;
    private String description;
    private ArrayList<String> tags = new ArrayList<>();
    private ArrayList<String> guests = new ArrayList<>();
    private String dateStart;
    private String dateEnd;
    private String eventPlace;

    public AddEventPresenter(AddEventInteractor addEventInteractor) {
        this.addEventInteractor = addEventInteractor;
    }


    public void onAddEventClicked() {
        //view.showProgress();
        Event eventSketch = new Event(nameHost,"1", nameEvent, description, eventPlace, tags, guests, dateStart, dateEnd);
        addEventInteractor.addEvent(eventSketch, new Carry<Event>() {
            @Override
            public void onSuccess(Event result) {
                view.hideProgress();
                view.showProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });


    }



    public void onTagSelected(String tag) {
        if(tags.contains(tag)) {
           // tags.remove(tags.size()-1);
            for(int i=0;i<tags.size();i++){
                if(tags.get(i).equals(tag)) tags.remove(i);
            }
        } else {
            tags.add(tag);
        }
    }

    public void onNameEventChanged(CharSequence nameEvent){
        this.nameEvent = nameEvent.toString();
    }
    public void onPlaceChanged(CharSequence eventPlace){
        this.eventPlace = eventPlace.toString();
    }
    public void onNameHostChanged(CharSequence nameHost){
        this.nameHost = nameHost.toString();
    }

    public void onDescriptionChanged(CharSequence description){
        this.description = description.toString();
    }
    public void onDataStartChanged(String dateStart){
        this.dateStart = dateStart;
    }
    public void onDataEndChanged(String dateEnd){
        this.dateEnd = dateEnd;
    }


}
