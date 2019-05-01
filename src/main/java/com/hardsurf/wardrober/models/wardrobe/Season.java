package com.hardsurf.wardrober.models.wardrobe;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Season {

    private Double minTemp;
    private Double maxTemp;
    private String id;

    private Season(Double minTemp, Double maxTemp, String id) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.id = id;
    }

    public static class Seasons {
        public final static Enumeration<Season> enumeration = new Enumeration<>(
                new Season(10.0, 15.0, "Mid-spring/mid-autumn"),
                new Season(4.0, 10.0, "Early spring/late autumn"),
                new Season(22.0, 33.0, "Summer"),
                new Season(-10.0, 0.0, "Winter"),
                new Season(-25.0, -10.0, "Cold winter"),
                new Season(15.0, 22.0, "Late spring/early autumn")
        );
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
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

    public static Season byId(@NotNull @NotEmpty String id) {
        return Seasons.enumeration.getElem(season -> season.id.equals(id));
    }

}
