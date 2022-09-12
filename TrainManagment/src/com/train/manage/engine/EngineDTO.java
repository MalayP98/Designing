package com.train.manage.engine;

public class EngineDTO {

    private String make;

    private Integer maxSpeed;

    public EngineDTO(String make, Integer maxSpeed) {
        this.make = make;
        this.maxSpeed = maxSpeed;
    }

    public String getMake() {
        return make;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }
}
