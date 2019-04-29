package com.hardsurf.wardrober.models.wardrobe;

import java.io.Serializable;

public class RgbColor implements Serializable {
    private Byte red;
    private Byte green;
    private Byte blue;

    public RgbColor(Byte red, Byte green, Byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Byte getRed() {
        return red;
    }

    public void setRed(Byte red) {
        this.red = red;
    }

    public Byte getGreen() {
        return green;
    }

    public void setGreen(Byte green) {
        this.green = green;
    }

    public Byte getBlue() {
        return blue;
    }

    public void setBlue(Byte blue) {
        this.blue = blue;
    }
}
