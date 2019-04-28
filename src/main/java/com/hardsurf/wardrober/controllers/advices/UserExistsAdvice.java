package com.hardsurf.wardrober.controllers.advices;

import com.hardsurf.wardrober.exceptions.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExistsAdvice {

    @ResponseBody
    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String userExistsHandler(UserExistsException ex) {
        return ex.getMessage();
    }

}
