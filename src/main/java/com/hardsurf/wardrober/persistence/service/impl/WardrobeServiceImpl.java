package com.hardsurf.wardrober.persistence.service.impl;

import com.hardsurf.wardrober.exceptions.ItemNotFoundException;
import com.hardsurf.wardrober.models.wardrobe.Season;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItem;
import com.hardsurf.wardrober.persistence.dto.UserDto;
import com.hardsurf.wardrober.persistence.dto.WardrobeItemDto;
import com.hardsurf.wardrober.persistence.repository.UserRepository;
import com.hardsurf.wardrober.persistence.repository.WardrobeRepository;
import com.hardsurf.wardrober.persistence.service.WardrobeService;
import com.hardsurf.wardrober.utils.ClothesCombiner;
import com.hardsurf.wardrober.utils.ClothesCombinerArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardrobeServiceImpl implements WardrobeService {

    private WardrobeRepository wardrobeRepo;
    private UserRepository userRepo;

    public WardrobeServiceImpl(@Autowired WardrobeRepository wardrobeRepo,
                               @Autowired UserRepository userRepo) {
        this.wardrobeRepo = wardrobeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<WardrobeItem> wardrobeByEmail(@NotNull @NotEmpty String email) {
        return wardrobeRepo
                .findAllByUser_Email(email)
                .stream()
                .map(WardrobeItem::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<WardrobeItem> wardrobeBySeason(@NotNull @NotEmpty String userEmail,
                                               @NotNull @NotEmpty Season season) {
        return wardrobeRepo
                .findAllByUser_EmailAndSeason(userEmail, season.toString())
                .stream()
                .map(WardrobeItem::new)
                .collect(Collectors.toList());
    }

    @Override
    public void create(@NotNull @NotEmpty String userEmail, WardrobeItem wardrobeItem) throws UsernameNotFoundException {
        UserDto userDto = userRepo.findByEmail(userEmail)
                            .orElseThrow(() ->
                                new UsernameNotFoundException(
                                    "Cannot add wardrobe item: user doesn't exist! <" + userEmail + ">"
                                )
                            );
        wardrobeRepo.save(new WardrobeItemDto(
                userDto,
                wardrobeItem.getName(),
                wardrobeItem.getType().toString(),
                wardrobeItem.getSeason().toString(),
                wardrobeItem.getColor()
        ));
    }

    @Override
    public void delete(@NotNull @NotEmpty String userEmail, @NotNull @NotEmpty String byItemName)
            throws UsernameNotFoundException, ItemNotFoundException {
        UserDto userDto = userRepo.findByEmail(userEmail)
                                  .orElseThrow(() ->
                                          new UsernameNotFoundException(
                                                  "Cannot delete item: owner does not exist! <" + userEmail + ">"
                                          )
                                  );
        WardrobeItemDto item = wardrobeRepo.findByUser_EmailAndName(userEmail, byItemName)
                                           .orElseThrow(() -> new ItemNotFoundException(byItemName));
        wardrobeRepo.delete(item);
    }

    @Override
    public List<WardrobeItem> clothesPack(@NotNull @NotEmpty String email) {
        return ClothesCombiner.combine(new ClothesCombinerArgs(
                20d,
                20d,
                wardrobeByEmail(email)
        ));
    }
}
