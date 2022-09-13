package com.train.manage.menus;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.service.StationService;

public class StationMenu {

    private StationService stationService;

    public StationMenu(StationService stationService) {
        this.stationService = stationService;
    }

    public void listAllStations() {
        List<Station> stations = stationService.getAllStations();
        int i = 1;
        for (Station station : stations) {
            System.out.println(i++ + ": " + station);
        }
    }

}
