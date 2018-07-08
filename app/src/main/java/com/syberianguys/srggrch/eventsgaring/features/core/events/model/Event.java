package com.syberianguys.srggrch.eventsgaring.features.core.events.model;

public class Event {
    private String id;
    private String name;
    private String host;
    private String description; //are we need additional var for short description
    private int[] tags;
    private int[] guests;
    private String start;
    private String end;
    private boolean isAvailable;

    public Event(String id, String host, String eventName, String description, int[] tags, int[] guests, String start, String end) {
        this.id = id;
        this.host = host;
        this.name = eventName;
        this.description = description;
        this.tags = tags;
        this.guests = guests;
        this.start = start;
        this.end = end;
    }

    public Event(String eventName, String host, String description, String start) {
        this.name = eventName;
        this.host = host;
        this.description = description;
        // this.tags = tags;
        this.start = start;
        //this.dateEnd = dateEnd;
    }


    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getDescription() {
        return description;
    }

    public int[] getTags() {
        return tags;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int[] getGuests() {
        return guests;
    }

    public String getId() {
        return id;
    }
}
