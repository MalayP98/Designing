package com.train.manage.initiators;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.Station;
import com.train.manage.Util;

public class StationInitiator {

    private final static String STATION = "Station_";

    private static List<Station> STATIONS = new ArrayList<>();

    private static Boolean created = false;

    public static void createStations(int stationCount) {
        if (created) {
            System.out.println("Station already");
            return;
        }
        for (int i = 1; i <= stationCount; i++) {
            STATIONS.add(new Station(i, STATION + String.valueOf(i), Util.getRandomNumber(1, 8)));
        }
        created = true;
    }

    public static List<Station> getStations() {
        return STATIONS;
    }
}
