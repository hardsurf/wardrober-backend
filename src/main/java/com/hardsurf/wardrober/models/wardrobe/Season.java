package com.hardsurf.wardrober.models.wardrobe;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Season {
    SPRING_AUTUMN(10.0, 15.0, "Mid-spring/mid-autumn"),
    COLD_SPRING_AUTUMN(4.0, 10.0, "Early spring/late autumn"),
    SUMMER(22.0, 33.0, "Summer"),
    WINTER(-10.0, 0.0, "Winter"),
    COLD_WINTER(-25.0, -10.0, "Cold winter"),
    PRE_SUMMER(15.0, 22.0, "Late spring/early autumn");

    private Double minTemp;
    private Double maxTemp;
    private String id;

    private Season(Double minTemp, Double maxTemp, String id) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    public static Season byId(@NotNull @NotEmpty String id) {
        return Arrays.stream(Season.values())
                .filter(s -> s.id.equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

}
