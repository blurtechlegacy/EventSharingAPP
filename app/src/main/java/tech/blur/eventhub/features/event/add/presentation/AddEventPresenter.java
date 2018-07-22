package tech.blur.eventhub.features.event.add.presentation;

import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.add.domain.AddEventInteractor;
import tech.blur.eventhub.network.Carry;

import java.util.ArrayList;
import java.util.List;

public class AddEventPresenter extends MvpPresenter<AddEventView> {
    private final AddEventInteractor addEventInteractor;

    private String nameEvent;
    private String description;
    private ArrayList<String> tags = new ArrayList<>();
    private ArrayList<String> guests = new ArrayList<>();
    private String dateStart;
    private String dateEnd;
    private String eventPlace;
    private User user;

    public AddEventPresenter(AddEventInteractor addEventInteractor) {
        this.addEventInteractor = addEventInteractor;
    }


    public void onAddEventClicked() {
        //view.showProgress();
        if ((dateEnd == null)||(dateStart == null)) view.dateEmptyError();
        else {
            view.showProgress();
            user = addEventInteractor.getUser();
            Event eventSketch = new Event(user.getId(), user.getLogin(), nameEvent, description, eventPlace, tags, guests, dateStart, dateEnd);
            addEventInteractor.addEvent(eventSketch, new Carry<Event>() {
                @Override
                public void onSuccess(Event result) {
                    view.hideProgress();
                }

                @Override
                public void onFailure(Throwable throwable) {
                    view.showError(throwable.getMessage());
                }
            });
        }

    }
    @Override
    protected void onViewReady() {
        loadTags();
        // loadUser();



    }

    private void loadTags() {
        view.showProgress();
        addEventInteractor.addTag(new Carry<List<Tag>>() {
            @Override
            public void onSuccess(List<Tag> result) {
                view.showTagList(result);
              //  view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
            //    view.hideProgress();
                view.showError(throwable.toString());
            }
        });
    }

    public void onTagSelected(String tag) {
        if(tags.contains(tag)) {
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
