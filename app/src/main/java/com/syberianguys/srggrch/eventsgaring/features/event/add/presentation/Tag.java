package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

public class Tag {
    private String id;
    private String tagText;
    private boolean isTagSelected;

    public Tag(String id, String tagText, boolean isTagSelected) {
        this.id = id;
        this.tagText = tagText;
        this.isTagSelected = isTagSelected;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
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
