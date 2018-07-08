package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

public class Tag {
    private String tagText;
    private boolean isTagSelected;

    public Tag(String tagText, boolean isTagSelected) {
        this.tagText = tagText;
        this.isTagSelected = isTagSelected;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    public boolean isTagSelected() {
        return isTagSelected;
    }

    public void setTagSelected(boolean tagSelected) {
        isTagSelected = tagSelected;
    }
}
