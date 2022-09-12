package com.train.manage.train;

import java.util.List;
import com.train.manage.engine.Engine;

public class TrainDTO {

    private String name;

    private List<Integer> route;

    private Engine engine;

    public TrainDTO(String name, List<Integer> route, Engine engine) {
        this.name = name;
        this.route = route;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRoute() {
        return route;
    }
}
