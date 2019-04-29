package com.hardsurf.wardrober.models.wardrobe;

import com.hardsurf.wardrober.persistence.dto.WardrobeItemDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WardrobeItem {

    private Season season;
    private WardrobeItemType type;
    private RgbColor color;
    private @NotNull @NotEmpty String name;

    public WardrobeItem(@NotNull @NotEmpty String season,
                        @NotNull @NotEmpty String type,
                        RgbColor color,
                        @NotNull @NotEmpty String name) {
        this.season = Season.byId(season);
        this.type = WardrobeItemType.valueOf(type);
        this.color = color;
        this.name = name;
    }

    public WardrobeItem(WardrobeItemDto fromDto) {
        this(fromDto.getSeason(),
             fromDto.getItemType(),
             fromDto.getColor(),
             fromDto.getName());
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public WardrobeItemType getType() {
        return type;
    }

    public void setType(WardrobeItemType type) {
        this.type = type;
    }

    public RgbColor getColor() {
        return color;
    }

    public void setColor(RgbColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
