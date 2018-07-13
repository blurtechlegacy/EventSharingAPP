package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

public class Tag {
    private String id;
    private String name;
    private boolean isTagSelected;

    public Tag(String id, String name, boolean isTagSelected) {
        this.id = id;
        this.name = name;
        this.isTagSelected = isTagSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public boolean isTagSelected() {
        return isTagSelected;
    }

    public void setTagSelected(boolean tagSelected) {
        isTagSelected = tagSelected;
    }
}
