package tech.blur.eventhub.features.event.add.presentation;

import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;

import java.util.List;

public interface AddEventView extends MvpView {
    void showProgress();

    void hideProgress();

    void dateEmptyError();

    void showError(String message);

    void showTagList(List<Tag> list);


}
