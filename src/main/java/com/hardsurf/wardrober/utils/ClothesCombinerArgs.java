package com.hardsurf.wardrober.utils;

import com.hardsurf.wardrober.models.wardrobe.WardrobeItem;

import java.util.Collection;

public class ClothesCombinerArgs {
    private Double temperature;
    private Double percipitation;
    private Collection<WardrobeItem> wardrobeItems;

    public ClothesCombinerArgs(Double temperature, Double percipitation, Collection<WardrobeItem> wardrobeItems) {
        this.temperature = temperature;
        this.percipitation = percipitation;
        this.wardrobeItems = wardrobeItems;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPercipitation() {
        return percipitation;
    }

    public void setPercipitation(Double percipitation) {
        this.percipitation = percipitation;
    }

    public Collection<WardrobeItem> getWardrobeItems() {
        return wardrobeItems;
    }

    public void setWardrobeItems(Collection<WardrobeItem> wardrobeItems) {
        this.wardrobeItems = wardrobeItems;
    }
}
