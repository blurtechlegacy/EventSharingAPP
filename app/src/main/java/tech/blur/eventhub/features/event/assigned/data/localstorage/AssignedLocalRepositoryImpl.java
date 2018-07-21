package tech.blur.eventhub.features.event.assigned.data.localstorage;

import tech.blur.eventhub.features.event.my.data.localstorage.MyEventsLocalDataSource;

public class AssignedLocalRepositoryImpl implements AssignedLocalRepository {
    private final AssignedLocalDataSource asEventsLocalDataSource;

    public AssignedLocalRepositoryImpl(AssignedLocalDataSource asEventsLocalDataSource) {
        this.asEventsLocalDataSource = asEventsLocalDataSource;
    }

    @Override
    public String getUserHost() {
        return asEventsLocalDataSource.getUserHost();
    }
}
