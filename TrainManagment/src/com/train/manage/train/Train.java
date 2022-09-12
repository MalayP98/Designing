package com.train.manage.train;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.Util;
import com.train.manage.engine.Engine;
import com.train.manage.route.Route;

public class Train {

    private int trainNumber;

    private String name;

    private Route route;

    private List<Float> travelTime;

    private Engine engine;

    public Train(String name, Route route, Engine engine) {
        this.trainNumber = Util.getRandomNumber(1, 9999);
        this.name = name;
        this.route = route;
        this.engine = engine;
    }

    private void calculateTravelTime() {

    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getName() {
        return name;
    }

    public Station nextStation() {
        return route.nextStation();
    }

    public Station currentStation() {
        return route.currentStation();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "{train_number = " + trainNumber + ", name = " + name + ", source = "
                + route.getSource() + ", destination = " + route.getDestination() + "}";
    }
}
