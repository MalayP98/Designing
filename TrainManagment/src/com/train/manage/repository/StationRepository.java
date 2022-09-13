package com.train.manage.repository;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.initiators.StationInitiator;

public class StationRepository implements Repository<Station> {

    private final List<Station> stations = StationInitiator.getStations();

    private static StationRepository INSTANCE = null;

    private StationRepository() {
    }

    public static StationRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StationRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Station object) {
        return false;
    }

    @Override
    public boolean update(int index, Station station) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public Station get(int index) {
        return stations.get(index);
    }

    public List<Station> getAll() {
        return stations;
    }
}
