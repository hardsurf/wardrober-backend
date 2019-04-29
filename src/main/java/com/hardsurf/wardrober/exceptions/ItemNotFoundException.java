package com.hardsurf.wardrober.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String itemName) {
        super("Cannot find item with specified name! <" + itemName + ">");
    }
}
