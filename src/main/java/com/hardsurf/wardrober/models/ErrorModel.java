package com.hardsurf.wardrober.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ErrorModel {
    private String error;
    private String success;

    public ErrorModel(@NotNull @NotEmpty String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
