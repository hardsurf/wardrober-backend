package com.hardsurf.wardrober.exceptions;

public class WeatherFetchException extends RuntimeException {
    public WeatherFetchException(String url) {
        super("Failed to fetch weather from API! <" + url + ">");
    }
}
