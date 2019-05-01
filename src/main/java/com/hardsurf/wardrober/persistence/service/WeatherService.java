package com.hardsurf.wardrober.persistence.service;

import com.hardsurf.wardrober.models.WeatherModel;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    WeatherModel getWeather(String location);
}
