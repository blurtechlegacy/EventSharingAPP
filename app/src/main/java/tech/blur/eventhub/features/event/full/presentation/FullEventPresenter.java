package tech.blur.eventhub.features.event.full.presentation;

import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.domain.FullEventInteracor;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;
import tech.blur.eventhub.network.Carry;

import java.util.ArrayList;
import java.util.List;

import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public class FullEventPresenter extends MvpPresenter<FullActivityView> {

    private final FullEventInteracor fullEventInteracor;
    private String id;
    private List<Tag> allTags;
    private List<Tag> tags = new ArrayList<>();

    public FullEventPresenter(FullEventInteracor fullEventInteracor) {
        this.fullEventInteracor = fullEventInteracor;
    }

    @Override
    protected void onViewReady() {
        view.showProgress();
        getTags();

    }


    private void getTags(){
        fullEventInteracor.getTags(new Carry<List<Tag>>() {
            @Override
            public void onSuccess(List<Tag> result) {
                allTags = result;
                fullEventInteracor.loadEvent(new Carry<Event>() {
                    @Override
                    public void onSuccess(Event result) {

                        tags.clear();
                        for(int i = 0; i< allTags.size(); i++){
                            if (result.getTags().contains(allTags.get(i).getId())) tags.add(allTags.get(i));
                        }
                        view.hideProgress();
                        view.showEvent(result, tags);
                        view.addMarker(result.getPlace());
                        if ((result.getGuests() != null)&&(result.getGuests().contains(fullEventInteracor.getUserId()))) view.assignDone();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        view.showError(throwable.getMessage());
                    }
                }, id);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

//    private void loadEvent(String id) {
//        view.showProgress();
//        fullEventInteracor.loadEvent(new Carry<Event>() {
//
//            @Override
//            public void onSuccess(Event result) {
//                view.showEvent(result);
//                view.hideProgress();
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                view.showError(throwable.toString());
//                view.hideProgress();
//            }
//        }, id);
//    }

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
