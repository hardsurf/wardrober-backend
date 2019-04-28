package com.hardsurf.wardrober.persistence.service.impl;

import com.hardsurf.wardrober.exceptions.UserExistsException;
import com.hardsurf.wardrober.models.UserModel;
import com.hardsurf.wardrober.models.UserSignupModel;
import com.hardsurf.wardrober.persistence.dto.UserDto;
import com.hardsurf.wardrober.persistence.repository.UserRepository;
import com.hardsurf.wardrober.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(@Autowired UserRepository userRepo,
                           @Autowired PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(@NotNull UserSignupModel userSignupModel) throws UserExistsException {
        if (userRepo.findByEmail(userSignupModel.getEmail()).isPresent()) {
            throw new UserExistsException(userSignupModel.getEmail());
        }
        UserDto fromSignupModel = new UserDto(
                userSignupModel.getNickName(),
                passwordEncoder.encode(userSignupModel.getPassword()),
                userSignupModel.getEmail()
        );
        userRepo.save(fromSignupModel);
    }

    @Override
    public UserModel getUser(@NotNull String email) {
        return userRepo
                .findByEmail(email)
                .map(UserModel::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "No user with specified email address exists! <" + email + ">"
                        )
                );
    }
}
