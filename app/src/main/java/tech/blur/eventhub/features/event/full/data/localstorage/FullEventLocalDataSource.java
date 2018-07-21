package tech.blur.eventhub.features.event.full.data.localstorage;

public interface FullEventLocalDataSource {
    String getUserId();
    String getString(String key);
}
