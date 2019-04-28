package com.hardsurf.wardrober.persistence.repository;

import com.hardsurf.wardrober.persistence.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {
    Optional<UserDto> findByEmail(@NotNull String email);
}
