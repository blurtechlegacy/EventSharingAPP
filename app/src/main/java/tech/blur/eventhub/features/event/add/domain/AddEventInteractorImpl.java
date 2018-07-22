package tech.blur.eventhub.features.event.add.domain;

import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.add.data.AddEventRepository;
import tech.blur.eventhub.features.event.add.data.localstorage.AddEventLocalRepository;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.network.Carry;

import java.util.List;

import tech.blur.eventhub.features.event.add.presentation.Tag;

public class AddEventInteractorImpl implements AddEventInteractor {
    private final AddEventRepository addEventRepository;
    private final AddEventLocalRepository localRepository;

    public AddEventInteractorImpl(AddEventRepository addEventRepository, AddEventLocalRepository localRepository) {
        this.addEventRepository = addEventRepository;
        this.localRepository = localRepository;
    }

    @Override
    public void addEvent(Event event, Carry<Event> carry) {
        addEventRepository.addEvent(event, carry);
    }

    @Override
    public void addTag(Carry<List<Tag>> carry) {
        addEventRepository.addTags(carry);
    }


    @Override
    public User getUser() {
        return localRepository.getUser();
    }
}
