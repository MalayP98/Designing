package com.train.manage.service;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.StationRepository;

public class StationService {

    private static StationService INSTANCE = null;

    private StationRepository stationRepository;

    private StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public static StationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StationService(StationRepository.getInstance());
        }
        return INSTANCE;
    }

    public List<Station> getAllStations() {
        return stationRepository.getAll();
    }

    public Station getStation(int index) {
        if (index >= getAllStations().size() || index < 0)
            return null;
        return getAllStations().get(index - 1);
    }
}
