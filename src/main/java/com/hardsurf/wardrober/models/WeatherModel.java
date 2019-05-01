package com.hardsurf.wardrober.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {

    @JsonProperty("feelslike_c")
    private Double temperature;

    @JsonProperty("precip_mm")
    private Double percipitation;

    private Double cloud;

    public WeatherModel(Double temperature, Double percipitation, Double cloud) {
        this.temperature = temperature;
        this.percipitation = percipitation;
        this.cloud = cloud;
    }

    public WeatherModel() {}

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPercipitation() {
        return percipitation;
    }

    public void setPercipitation(Double percipitation) {
        this.percipitation = percipitation;
    }

    public Double getCloud() {
        return cloud;
    }

    public void setCloud(Double cloud) {
        this.cloud = cloud;
    }
}
