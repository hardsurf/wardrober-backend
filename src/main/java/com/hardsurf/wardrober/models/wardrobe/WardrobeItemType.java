package com.hardsurf.wardrober.models.wardrobe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WardrobeItemType {

    private String id;
    private String icon;
    private BodyPart bodyPart;

    private WardrobeItemType(String id, String icon, BodyPart bodyPart) {
        this.id = id;
        this.icon = icon;
        this.bodyPart = bodyPart;
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

    public static class WardrobeItemTypes {
        public final static Enumeration<WardrobeItemType> enumeration = new Enumeration<>(
                new WardrobeItemType("T-Shirt", "tshirt.svg", BodyPart.byId("Torso")),
                new WardrobeItemType("Jeans", BodyPart.byId("Legs")),
                new WardrobeItemType("Sneakers", BodyPart.byId("Shoes")),
                new WardrobeItemType("Trousers", BodyPart.byId("Legs")),
                new WardrobeItemType("Mittens", BodyPart.byId("Hands")),
                new WardrobeItemType("Sun glasses", "sunglasses.svg", BodyPart.byId("Head")),
                new WardrobeItemType("Beanie", BodyPart.byId("Head")),
                new WardrobeItemType("Shirt", BodyPart.byId("Torso"))
                // TODO: fill in
        );
    }

    private WardrobeItemType(String id, BodyPart bodyPart) {
        this(id, id.toLowerCase() + ".svg", bodyPart);
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
