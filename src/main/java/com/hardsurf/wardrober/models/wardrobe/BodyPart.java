package com.hardsurf.wardrober.models.wardrobe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BodyPart {
    private String id;

    public BodyPart(String id) {
        this.id = id;
    }

    public static class BodyParts {
        public static Enumeration<BodyPart> enumeration = new Enumeration<BodyPart>(
                new BodyPart("Head"),
                new BodyPart("Torso"),
                new BodyPart("Hands"),
                new BodyPart("Legs"),
                new BodyPart("Shoes")
        );
    }

    public static BodyPart byId(@NotNull @NotEmpty String id) {
        return BodyParts.enumeration.getElem(bodyPart -> bodyPart.id.equals(id));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}