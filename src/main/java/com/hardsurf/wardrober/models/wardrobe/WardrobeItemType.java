package com.hardsurf.wardrober.models.wardrobe;

public enum WardrobeItemType {
    TSHIRT("T-Shirt", "tshirt.svg", BodyPart.TORSO),
    JEANS("Jeans", BodyPart.LEGS),
    SNEAKERS("Sneakers", BodyPart.SHOES),
    TROUSERS("Trousers", BodyPart.LEGS),
    MITTENS("Mittens", BodyPart.HANDS),
    SUNGLASSES("Sun glasses", "sunglasses.svg", BodyPart.HEAD),
    BEANIE("Beanie", BodyPart.HEAD),
    SHIRT("Shirt", BodyPart.TORSO);
    // TODO: fill in


    private String id;
    private String icon;
    private BodyPart bodyPart;

    private WardrobeItemType(String id, String icon, BodyPart bodyPart) {
        this.id = id;
        this.icon = icon;
        this.bodyPart = bodyPart;
    }

    private WardrobeItemType(String id, BodyPart bodyPart) {
        this(id, id.toLowerCase() + ".svg", bodyPart);
    }

    public String getIconName() {
        return icon;
    }

    @Override
    public String toString() {
        return id;
    }


}
