package com.train.manage.initiators;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.Station;
import com.train.manage.Util;

public class TrackInitiator {

    private static final List<List<Integer>> TRACKS = new ArrayList<>();

    private static Boolean created = false;

    private static void initializeTracks(int stationCount) {
        for (int i = 0; i < stationCount; i++) {
            List<Integer> child = new ArrayList<>();
            for (int j = 0; j < stationCount; j++) {
                child.add(0);
            }
            TRACKS.add(child);
        }
    }

    public static List<List<Integer>> getTrack() {
        return TRACKS;
    }

    public static void createTracks(List<Station> stations) {
        if (created) {
            System.out.println("Tracks are created and ready to use!");
            return;
        }
        initializeTracks(stations.size());
        int stationCount = stations.size();
        for (int i = 0; i < stationCount; i++) {
            addTracks(i, stations);
        }
        created = true;
    }

    private static void addTracks(int parentStationIndex, List<Station> stations) {
        int tracks = Util.getRandomNumber(1, Math.min(3, stations.size()));
        while (tracks != 0) {
            TRACKS.get(parentStationIndex).add(
                    destinationTracks(parentStationIndex, stations).getId() - 1,
                    Util.getRandomNumber(1, 10));
            tracks--;
        }
    }

    private static Station destinationTracks(int parentStationIndex, List<Station> stations) {
        int stationToPick = -1;
        do {
            stationToPick = Util.getRandomNumber(0, stations.size() - 1);
        } while (stationToPick == parentStationIndex);
        return stations.get(stationToPick);
    }

    public static void display() {
        for (int i = 0; i < TRACKS.size(); i++) {
            for (int j = 0; j < TRACKS.size(); j++) {
                System.out.print(TRACKS.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static Integer getCellValue(int x, int y) {
        if (x >= TRACKS.size() || x < 0 || y >= TRACKS.size() || y < 0)
            return -1;
        return TRACKS.get(x).get(y);
    }
}
