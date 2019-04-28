package com.hardsurf.wardrober.exceptions;

import javax.validation.constraints.NotNull;

public class UserExistsException extends RuntimeException {
    public UserExistsException(@NotNull String email) {
        super("Email already in use! <" + email + ">");
    }
}
