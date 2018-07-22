package tech.blur.eventhub.features.event.list.presentation;

import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;

import java.util.List;

public interface EventListView extends MvpView{
    void showProgress();

    void hideProgress();

    void showEventList(List<Event> list);

    void signOutDone(Boolean isAuth);

//    void setUser (User user);

    void showError(String message);
}
