package com.hardsurf.wardrober.persistence.service;

import com.hardsurf.wardrober.exceptions.ItemNotFoundException;
import com.hardsurf.wardrober.models.wardrobe.Season;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItem;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface WardrobeService {
    List<WardrobeItem> wardrobeByEmail(@NotNull @NotEmpty String email);
    List<WardrobeItem> wardrobeBySeason(@NotNull @NotEmpty String userEmail, Season season);
    void create(@NotNull @NotEmpty String userEmail, WardrobeItem wardrobeItem) throws UsernameNotFoundException;
    void delete(@NotNull @NotEmpty String userEmail, @NotNull @NotEmpty String byItemName)
            throws UsernameNotFoundException, ItemNotFoundException;
    List<WardrobeItem> clothesPack(@NotNull @NotEmpty String email);
}
