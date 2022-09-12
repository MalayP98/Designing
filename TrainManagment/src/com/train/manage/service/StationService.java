package com.train.manage.service;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.StationRepository;

public class StationService {

    private StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations() {
        return stationRepository.getAll();
    }

    public Station getStation(int index) {
        if (index >= getAllStations().size() || index < 0)
            return null;
        return getAllStations().get(index - 1);
    }

    public void listAllStation() {
        int i = 1;
        for (Station station : getAllStations()) {
            System.out.println(i++ + ": " + station);
        }
    }
}
