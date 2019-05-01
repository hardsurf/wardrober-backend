package com.hardsurf.wardrober.controllers;

import com.hardsurf.wardrober.models.wardrobe.BodyPart;
import com.hardsurf.wardrober.models.wardrobe.Season;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItem;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItemType;
import com.hardsurf.wardrober.persistence.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
public class WardrobeController {

    private WardrobeService wardrobeService;

    public WardrobeController(@Autowired WardrobeService wardrobeService) {
        this.wardrobeService = wardrobeService;
    }

    @GetMapping("/dropdowns/bodyparts")
    public List<BodyPart> bodyParts() {
        return BodyPart.BodyParts.enumeration.values();
    }

    @GetMapping("/dropdowns/clothestypes")
    public List<WardrobeItemType> clothesTypes() {
        return WardrobeItemType.WardrobeItemTypes.enumeration.values();
    }

    @GetMapping("/dropdowns/seasons")
    public List<Season> seasons() {
        return Season.Seasons.enumeration.values();
    }

    @GetMapping("/clothes/{username}")
    public List<WardrobeItem> userWardrobe(@PathVariable @NotNull @NotEmpty String username) {
        return wardrobeService.wardrobeByEmail(username);
    }

    @GetMapping("/clothes/{username}/generate")
    public List<WardrobeItem> generateClothesPack(@PathVariable @NotNull @NotEmpty String username) {
        return wardrobeService.clothesPack(username);
    }

    @GetMapping("/clothes/{username}/{season}")
    public List<WardrobeItem> wardrobeForSeason(@PathVariable @NotNull @NotEmpty String username,
                                                @PathVariable @NotNull @NotEmpty String season) {
        return wardrobeService.wardrobeBySeason(username, Season.byId(season));
    }

    @PostMapping("/clothes/{username}")
    public void createItem(@PathVariable @NotNull @NotEmpty String username,
                                   @RequestBody WardrobeItem wardrobeItem) {
        wardrobeService.create(username, wardrobeItem);
    }

    @DeleteMapping("/clothes/{username}/{itemname}")
    public void deleteItem(@PathVariable @NotNull @NotEmpty String username,
                           @PathVariable @NotNull @NotEmpty String itemname) {
        wardrobeService.delete(username, itemname);
    }

}
