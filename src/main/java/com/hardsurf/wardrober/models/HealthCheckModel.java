package com.hardsurf.wardrober.models;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


public class HealthCheckModel {
    private final Long runTime;
    private final static ZoneId zone = ZoneId.systemDefault();

    public HealthCheckModel(Instant startedAt) {
        this.runTime = startedAt.atZone(zone)
                            .until(Instant.now().atZone(zone), ChronoUnit.SECONDS);
    }

    public Long getRunTime() {
        return runTime;
    }
}
