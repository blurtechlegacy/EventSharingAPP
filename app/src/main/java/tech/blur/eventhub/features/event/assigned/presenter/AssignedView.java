package tech.blur.eventhub.features.event.assigned.presenter;

import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;

import java.util.List;

public interface AssignedView extends MvpView{
    void showProgress();

    void hideProgress();

    void showEventList(List<Event> list);

    void showError(String message);
}
