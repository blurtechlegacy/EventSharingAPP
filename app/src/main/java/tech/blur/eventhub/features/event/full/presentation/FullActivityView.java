package tech.blur.eventhub.features.event.full.presentation;

import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.Tag;

import java.util.ArrayList;
import java.util.List;

public interface FullActivityView extends MvpView {

    void showProgress();

    void hideProgress();

    void showEvent(Event event, List<Tag> tags);

    void showError(String message);

    void assignFailed();

    void assignDone();

    void addMarker(String coordinates);
}
