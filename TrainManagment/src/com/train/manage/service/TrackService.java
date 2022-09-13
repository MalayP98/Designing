package com.train.manage.service;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.TrackRepository;

public class TrackService {

    private static TrackService INSTANCE = null;

    private TrackRepository trackRepository;

    private TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public static TrackService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrackService(TrackRepository.getInstance());
        }
        return INSTANCE;
    }

    public int distance(Station A, Station B) {
        return distance(A.getId(), B.getId());
    }

    public int distance(int A, int B) {
        return trackRepository.distance(A - 1, B - 1);
    }

    public List<List<Integer>> getTracks() {
        return trackRepository.getTracks();
    }
}
