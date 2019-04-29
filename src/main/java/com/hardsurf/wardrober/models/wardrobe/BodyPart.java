package com.hardsurf.wardrober.models.wardrobe;

public class BodyPart {
    private String id;

    public BodyPart(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}