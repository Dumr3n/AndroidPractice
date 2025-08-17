package com.example.playgorund;

public class Planet {
    private String planetName;
    private String moonCount;
    private int planetImage;

    public Planet(int planetImage, String moonCount, String planetName) {
        this.planetImage = planetImage;
        this.moonCount = moonCount;
        this.planetName = planetName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
