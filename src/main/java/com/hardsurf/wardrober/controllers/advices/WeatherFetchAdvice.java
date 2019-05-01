package com.hardsurf.wardrober.controllers.advices;


import com.hardsurf.wardrober.exceptions.WeatherFetchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WeatherFetchAdvice {
    @ResponseBody
    @ExceptionHandler(WeatherFetchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String weatherNotFetchedHandler(WeatherFetchException ex) {
        return ex.getMessage();
    }
}