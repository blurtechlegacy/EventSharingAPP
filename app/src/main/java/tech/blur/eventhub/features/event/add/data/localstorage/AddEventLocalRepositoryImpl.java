package tech.blur.eventhub.features.event.add.data.localstorage;

import tech.blur.eventhub.features.core.events.model.User;

public class AddEventLocalRepositoryImpl implements AddEventLocalRepository {
    private final AddEventLocalDataSource dataSource;

    public AddEventLocalRepositoryImpl(AddEventLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User getUser() {
        return dataSource.getUser();
    }
}
