package com.train.manage.route;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import com.train.manage.Station;
import com.train.manage.initiators.TrackInitiator;

public class RouteFinder {

    private void search(HashMap<Long, Set<Station>> tracks, Station source, Station destination) {

    }

    public List<List<Station>> find(Station source, Station destination) {
        List<List<Integer>> tracks = TrackInitiator.getTrack();
        return null;
    }
}
