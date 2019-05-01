package com.hardsurf.wardrober.models.wardrobe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BodyPart {
    private String id;
    private Boolean mustBeClothed;

    public BodyPart(String id, Boolean mustBeClothed) {
        this.id = id;
        this.mustBeClothed = mustBeClothed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyPart bodyPart = (BodyPart) o;
        return getId().equals(bodyPart.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public BodyPart(String id) {
        this(id, true);
    }

    public static class BodyParts {
        public static Enumeration<BodyPart> enumeration = new Enumeration<BodyPart>(
                new BodyPart("Head", false),
                new BodyPart("Torso"),
                new BodyPart("Hands", false),
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

    public Boolean getMustBeClothed() {
        return mustBeClothed;
    }

    public void setMustBeClothed(Boolean mustBeClothed) {
        this.mustBeClothed = mustBeClothed;
    }

    @Override
    public String toString() {
        return id;
    }
}