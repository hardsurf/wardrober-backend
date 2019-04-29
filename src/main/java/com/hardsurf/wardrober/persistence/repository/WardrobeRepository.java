package com.hardsurf.wardrober.persistence.repository;

import com.hardsurf.wardrober.persistence.dto.WardrobeItemDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface WardrobeRepository extends CrudRepository<WardrobeItemDto, Long> {
    Collection<WardrobeItemDto> findAllByUser_Email(@NotNull @NotEmpty String email);
    Collection<WardrobeItemDto> findAllByUser_EmailAndSeason(@NotNull @NotEmpty String email,
                                                             @NotNull @NotEmpty String season);
    Optional<WardrobeItemDto> findByUser_EmailAndName(@NotNull @NotEmpty String email,
                                                      @NotNull @NotEmpty String name);
}
