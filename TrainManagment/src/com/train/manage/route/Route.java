package com.train.manage.route;

import java.util.List;
import com.train.manage.Station;

public class Route {

    private Station source;

    private Station destination;

    private List<Station> route;

    private int currentStation = 0;

    public Route(Station source, Station destination) {
        this.source = source;
        this.destination = destination;
    }

    public Station getSource() {
        return source;
    }

    public Station getDestination() {
        return destination;
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
