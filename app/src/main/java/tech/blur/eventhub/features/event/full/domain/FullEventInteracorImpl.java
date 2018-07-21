package tech.blur.eventhub.features.event.full.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.full.data.FullEventRepository;
import tech.blur.eventhub.features.event.full.data.localstorage.FullEventLocalRepository;
import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.full.domain.model.AssignEvent;

public class FullEventInteracorImpl implements FullEventInteracor {

    private final FullEventRepository fullEventRepository;
    private final FullEventLocalRepository fullEventLocalRepository;

    public FullEventInteracorImpl(FullEventRepository fullEventRepository, FullEventLocalRepository fullEventLocalRepository) {
        this.fullEventRepository = fullEventRepository;
        this.fullEventLocalRepository = fullEventLocalRepository;
    }

    @Override
    public void loadEvent(Carry<Event> carry, String id) {
        fullEventRepository.loadEvent(carry, id);
    }

    @Override
    public void getTags(Carry<List<Tag>> carry) {
        fullEventRepository.getTags(carry);
    }

    @Override
    public void assignEvent(AssignEvent assignEvent, Carry<Event> carry) {
        fullEventRepository.assignEvent(assignEvent, carry);
    }

    @Override
    public String getUserId() {
        return fullEventLocalRepository.getUserId();
    }

}
