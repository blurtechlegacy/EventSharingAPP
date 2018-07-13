package com.syberianguys.srggrch.eventsgaring.features.core.events.model;

import java.util.ArrayList;

public class Event {
    private String id;
    private String host;
    private String host_name;
    private String name;
    private String description; //are we need additional var for short description
    private String Place;
    private ArrayList<String> tags;
    private ArrayList<String> guests;
    private String start;
    private String end;
    private boolean isAvailable;

    public Event(String id, String host, String host_name, String name, String description, String place, ArrayList<String> tags, ArrayList<String> guests, String start, String end) {
        this.id = id;
        this.host = host;
        this.host_name = host_name;
        this.name = name;
        this.description = description;
        Place = place;
        this.tags = tags;
        this.guests = guests;
        this.start = start;
        this.end = end;
    }

    public Event(String host, String host_name, String name, String description, String place, ArrayList<String> tags, ArrayList<String> guests, String start, String end) {
        this.host = host;
        this.host_name = host_name;
        this.name = name;
        this.description = description;
        Place = place;
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

    public Event() {
    }

    public String getHost_name() { return host_name; }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTags() {
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

    public ArrayList<String> getGuests() {
        return guests;
    }

    public String getId() {
        return id;
    }
}
