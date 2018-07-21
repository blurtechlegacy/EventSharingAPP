package tech.blur.eventhub.features.event.my.presenter;

import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.my.domain.MyEventsInteractor;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.my.domain.MyEventsInteractor;

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
