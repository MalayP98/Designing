package com.train.manage;

import com.train.manage.route.Route;

public class Train {

    private int trainNumber;

    private String name;

    private Route route;

    private int waitingTime[];

    public Train(String name, Route route, int[] waitingTime) {
        this.name = name;
        this.route = route;
        initializeWaitingTime(route.routeSize());
    }

    private void initializeWaitingTime(int routeSize) {
        this.waitingTime = new int[routeSize];
        for (int i = 0; i < routeSize; i++) {
            waitingTime[i] = Util.getRandomNumber(1, 10);
        }
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
}
