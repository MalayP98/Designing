package com.train.manage.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.train.manage.Station;
import com.train.manage.repository.TrackRepository;
import com.train.manage.service.TrackService;

public class RouteFinder {

    private TrackService trackService;

    public RouteFinder() {
        trackService = new TrackService(new TrackRepository());
    }

    private void search(List<List<Integer>> tracks, int source, int destination,
            List<List<Integer>> routes, List<Integer> route, Map<Integer, Boolean> visited) {
        visited.put(source, true);
        route.add(source + 1);
        if (source == destination) {
            routes.add(new ArrayList<>(route));
        }
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(source).get(i) > 0 && (!visited.containsKey(i) || !visited.get(i))) {
                search(tracks, i, destination, routes, route, visited);
            }
        }
        visited.put(source, false);
        route.remove(route.size() - 1);
    }

    public List<List<Integer>> find(Station source, Station destination) {
        if (source == null || destination == null)
            return new ArrayList<>();
        System.out.println("Seaching route from " + source + " to " + destination + ".... \n");
        return find(source.getId(), destination.getId());
    }

    // TODO: add check if source and destination are valid or not.
    public List<List<Integer>> find(int source, int destination) {
        if (source == -1 || destination == -1)
            return new ArrayList<>();
        List<List<Integer>> routes = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        search(trackService.getTracks(), source - 1, destination - 1, routes, route, visited);
        return routes;
    }
}
