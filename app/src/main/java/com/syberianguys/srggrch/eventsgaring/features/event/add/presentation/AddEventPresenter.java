package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.domain.AddEventInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.ArrayList;
import java.util.List;

public class AddEventPresenter extends MvpPresenter<AddEventView> {
    private final AddEventInteractor addEventInteractor;

    private String nameEvent;
    private String nameHost;
    private String description;
    private ArrayList<Integer> tags;
    private String dateStart;
    private String dateEnd;

    public AddEventPresenter(AddEventInteractor addEventInteractor) {
        this.addEventInteractor = addEventInteractor;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(ArrayList<Integer> tags) {
        this.tags = tags;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void onAddEventClicked() {
        view.showProgress();
        Event eventSketch = new Event(nameEvent, nameHost, description, tags, dateStart, dateEnd);
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



    public void onTagSelected(int tag) {
        if(tags.contains(tag)) {
            tags.remove(tag);
        } else {
            tags.add(tag);
        }
    }

    public void onClickedAddNewEvent() {
        onAddEventClicked();
    }
}
