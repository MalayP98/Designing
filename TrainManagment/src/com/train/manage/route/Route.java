package com.train.manage.route;

import java.util.List;
import com.train.manage.Station;

public class Route {

    private final List<Station> route;

    private int currentStation = 0;

    public Route(List<Station> route) {
        this.route = route;
    }

    public Station getSource() {
        return route.get(0);
    }

    public Station getDestination() {
        return route.get(routeSize() - 1);
    }

    public Station currentStation() {
        return route.get(currentStation);
    }

    public Station nextStation() {
        Station nextStation = route.get(currentStation);
        currentStation = (currentStation + 1) % routeSize();
        return nextStation;
    }

    public List<Station> getRoute() {
        return route;
    }

    public int routeSize() {
        return route.size();
    }
}
