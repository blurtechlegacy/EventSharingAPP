package tech.blur.eventhub.features.event.full.domain.model;

public class AssignEvent {
    private final String user_id;
    private final String event_id;

    public AssignEvent(String user_id, String event_id) {
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getEvent_id() {
        return event_id;
    }


}
