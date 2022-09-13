package com.train.manage.repository;

import java.util.List;
import com.train.manage.initiators.TrackInitiator;

public class TrackRepository implements Repository<List<List<Integer>>> {

    private static TrackRepository INSTANCE = null;

    private TrackRepository() {
    }

    public static TrackRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrackRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(List<List<Integer>> object) {
        return false;
    }

    @Override
    public boolean update(int index, List<List<Integer>> object) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public List<List<Integer>> get(int index) {
        return TrackInitiator.getTrack();
    }

    public Integer distance(int x, int y) {
        return TrackInitiator.getCellValue(x, y);
    }

    public List<List<Integer>> getTracks() {
        return TrackInitiator.getTrack();
    }
}
