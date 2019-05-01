package com.hardsurf.wardrober.persistence.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hardsurf.wardrober.exceptions.WeatherFetchException;
import com.hardsurf.wardrober.models.WeatherModel;
import com.hardsurf.wardrober.persistence.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${wardrober.weather.apiurl}")
    private String API_URL;

    @Override
    public WeatherModel getWeather(String location) throws WeatherFetchException {
        String url = API_URL + location;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode != HttpStatus.OK.value()) {
                throw new IOException("Failed to fetch weather from api! <" + obj.toString() + ">");
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String responseBody = in.lines().collect(Collectors.joining());
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            String current = mapper
                    .readTree(responseBody)
                    .get("current")
                    .toString();
            return mapper.readValue(current, WeatherModel.class);
        } catch (IOException e) {
            throw new WeatherFetchException(url);
        }

    }
}
