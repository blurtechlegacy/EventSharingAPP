package com.syberianguys.srggrch.eventsgaring.features.core.events.model;

public class User {

    private String id;
    private String login;
    private String name;
    private String birhday; //type?
    private int sex;

    public User(String id, String login, String name, String birhday, int sex) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.birhday = birhday;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getBirhday() {
        return birhday;
    }

    public int getSex() {
        return sex;
    }
}
