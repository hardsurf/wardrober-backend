package com.hardsurf.wardrober.controllers;

import com.hardsurf.wardrober.models.UserModel;
import com.hardsurf.wardrober.models.UserSignupModel;
import com.hardsurf.wardrober.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@RestController
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    void signup(@RequestBody UserSignupModel signupModel) {
        userService.register(signupModel);
    }

    @GetMapping("/users/{email}")
    UserModel user(@PathVariable @NotEmpty String email) {
        return userService.getUser(email);
    }
}
