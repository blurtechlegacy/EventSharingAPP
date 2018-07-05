package com.syberianguys.srggrch.eventsgaring.features.AllEvents.domain.model;

public class Event {
    private int id;
    private String eventName;
    private String host;
    private String descriptipon; //are we need additional var for short description
    private String[] tags;
    private String dateStart;
    private String dateEnd;
    private boolean isAvailable;

    public Event (String eventName, String host, String description, String[] tags, String dateStart, String dateEnd) {
        this.eventName = eventName;
        this.host = host;
        this.descriptipon = description;
        this.tags = tags;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Event (String eventName, String host, String description, String dateStart) {
        this.eventName = eventName;
        this.host = host;
        this.descriptipon = description;
       // this.tags = tags;
        this.dateStart = dateStart;
        //this.dateEnd = dateEnd;
    }


    public String getEventName() {
        return eventName;
    }

    public String getHost() {
        return host;
    }

    public String getDescriptipon() {
        return descriptipon;
    }

    public String[] getTags() {
        return tags;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd(){
        return dateEnd;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
