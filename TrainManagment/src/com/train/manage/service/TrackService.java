package com.train.manage.service;

import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.TrackRepository;

public class TrackService {

    private TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Integer distace(Station A, Station B) {
        return trackRepository.distance(A.getId() - 1, B.getId() - 1);
    }

    public List<List<Integer>> getTracks() {
        return trackRepository.getTracks();
    }
}
