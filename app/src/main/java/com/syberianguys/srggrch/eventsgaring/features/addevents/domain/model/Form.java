package com.syberianguys.srggrch.eventsgaring.features.addevents.domain.model;

public class Form {

        private int id;
        private String eventName;
        private String host;
        private String descriptipon; //are we need additional var for short description
        private String[] tags;
        private String dateStart;//date type?
        private String dateEnd;
        private boolean isAvailable;

    public Form(String eventName, String host, String descriptipon, String[] tags, String dateStart, String dateEnd) {
        this.eventName = eventName;
        this.host = host;
        this.descriptipon = descriptipon;
        this.tags = tags;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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

    public String getDateEnd() {
        return dateEnd;
    }
}
