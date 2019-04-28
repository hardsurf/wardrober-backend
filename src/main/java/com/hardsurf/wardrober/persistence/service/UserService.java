package com.hardsurf.wardrober.persistence.service;

import com.hardsurf.wardrober.exceptions.UserExistsException;
import com.hardsurf.wardrober.models.UserModel;
import com.hardsurf.wardrober.models.UserSignupModel;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public interface UserService {
    void register(@NotNull UserSignupModel userSignupModel) throws UserExistsException;
    UserModel getUser(@NotNull String email) throws UsernameNotFoundException;
}
