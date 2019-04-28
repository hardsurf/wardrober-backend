package com.hardsurf.wardrober.controllers;

import com.hardsurf.wardrober.utils.StartedAtBean;
import com.hardsurf.wardrober.models.HealthCheckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    private StartedAtBean startedAt;

    public HealthCheckController(@Autowired StartedAtBean startedAt) {
        this.startedAt = startedAt;
    }

    @GetMapping("/health")
    public HealthCheckModel health() {
        return new HealthCheckModel(startedAt.getStartedAt());
    }
}
