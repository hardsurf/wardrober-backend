package com.hardsurf.wardrober.persistence.dto;

import com.hardsurf.wardrober.models.wardrobe.RgbColor;
import com.hardsurf.wardrober.models.wardrobe.Season;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItemType;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
public class WardrobeItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(targetEntity = UserDto.class,
               cascade = CascadeType.DETACH,
               optional = false)
    private UserDto user;

    private String name;
    private String itemType;
    private String season;

    private RgbColor color;

    public WardrobeItemDto() {

    }

    public WardrobeItemDto(UserDto user, String name, String itemType, String season, RgbColor color) {
        this.user = user;
        this.name = name;
        this.itemType = itemType;
        this.season = season;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public RgbColor getColor() {
        return color;
    }

    public void setColor(RgbColor color) {
        this.color = color;
    }
}
