package com.train.manage.engine;

import java.util.Date;
import com.train.manage.Util;

public class Engine {

    private Integer engineId;

    private Date registrationDate;

    private String make;

    private Integer maxSpeed;

    public Engine(String make, Integer maxSpeed) {
        this.engineId = Util.getRandomNumber(1, 3000);
        this.registrationDate = new java.util.Date();
        this.make = make;
        this.maxSpeed = Math.max(5, Math.min(20, maxSpeed));
    }

    public Integer getEngineId() {
        return engineId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getMake() {
        return make;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "{make = " + make + ", max speed = " + maxSpeed + ", registered on = "
                + registrationDate + "}";
    }
}
