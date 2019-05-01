package com.hardsurf.wardrober.models.wardrobe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Stream;

public class WardrobeItemType {

    private String id;
    private String icon;
    private BodyPart bodyPart;
    private Collection<String> dependsOn;
    private Collection<String> mayDependOn;

    public WardrobeItemType(String id, String icon, BodyPart bodyPart, Collection<String> dependsOn, Collection<String> mayDependOn) {
        this.id = id;
        this.icon = icon;
        this.bodyPart = bodyPart;
        this.dependsOn = dependsOn;
        this.mayDependOn = mayDependOn;
    }

    public WardrobeItemType(String id, String icon, BodyPart bodyPart, Collection<String> mayDependOn) {
        this(id, icon, bodyPart, Collections.EMPTY_LIST, mayDependOn);
    }

    private WardrobeItemType(String id, String icon, BodyPart bodyPart) {
        this(id, icon, bodyPart, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Collection<String> getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(Collection<String> dependsOn) {
        this.dependsOn = dependsOn;
    }

    public Collection<String> getMayDependOn() {
        return mayDependOn;
    }

    public void setMayDependOn(Collection<String> mayDependOn) {
        this.mayDependOn = mayDependOn;
    }

    public static class WardrobeItemTypes {
        public final static Enumeration<WardrobeItemType> enumeration = new Enumeration<>(
                new WardrobeItemType("T-Shirt", "tshirt", BodyPart.byId("Torso")),
                new WardrobeItemType("Slippers", "shlepky", BodyPart.byId("Shoes")),
                new WardrobeItemType("Trousers", BodyPart.byId("Legs")),
                new WardrobeItemType("Sun glasses", "sunglasses", BodyPart.byId("Head")),
                new WardrobeItemType("Beanie", BodyPart.byId("Head")),
                new WardrobeItemType("Shirt", "shirt", BodyPart.byId("Torso"),
                        Collections.singletonList("T-Shirt")),
                new WardrobeItemType("Cap", "hat", BodyPart.byId("Head")),
                new WardrobeItemType("Winter jacket", "winter_jacket", BodyPart.byId("Torso"),
                        Arrays.asList("T-Shirt", "Shirt"), Collections.EMPTY_LIST)
                // TODO: fill in
        );
    }

    private WardrobeItemType(String id, BodyPart bodyPart) {
        this(id, id.toLowerCase(), bodyPart);
    }

    public String getIconName() {
        return icon;
    }

    public static WardrobeItemType byName(@NotNull @NotEmpty String name) {
        return WardrobeItemTypes.enumeration.getElem(wardrobeItemType -> wardrobeItemType.id.equals(name));
    }

    @Override
    public String toString() {
        return id;
    }


}
