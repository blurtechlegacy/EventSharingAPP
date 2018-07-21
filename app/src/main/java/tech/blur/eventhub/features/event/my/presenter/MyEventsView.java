package tech.blur.eventhub.features.event.my.presenter;

import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;

import java.util.List;

public interface MyEventsView extends MvpView{
    void showProgress();

    void hideProgress();

    void showEventList(List<Event> list);

    void showError(String message);
}
