package com.train.manage.route;

import java.util.List;
import com.train.manage.Station;

public class Route {

    private List<Station> route;

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
        if (currentStation == routeSize()) {
            return null;
        }
        return route.get(currentStation++);
    }

    public int routeSize() {
        return route.size();
    }
}
