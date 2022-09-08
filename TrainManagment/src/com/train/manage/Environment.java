package com.train.manage;

import java.util.List;
import java.util.Scanner;
import com.train.manage.initiators.StationInitiator;
import com.train.manage.initiators.TrackInitiator;

public class Environment {

    private static Environment INSTANCE = null;

    private static boolean created = false;

    private final String ADMIN_PASSWORD = "admin";

    public static Environment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Environment();
        }
        return INSTANCE;
    }

    public void create(int stationCount) {
        if (created) {
            System.out.println("Environment is ready!.");
        }
        System.out.println("Creating Environment.");
        StationInitiator.createStations(stationCount);
        TrackInitiator.createTracks(getStations());
        System.out.println("Environment created.");
        created = true;
    }

    public List<Station> getStations() {
        return StationInitiator.getStations();
    }

    public List<List<Integer>> getTracks() {
        return TrackInitiator.getTrack();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean isAdmin = false;
        System.out.println("Are you a admin? Press 'Y' for Yes and 'N' for No.");
        String input = sc.nextLine();
        if (input.equals("Y")) {
            int tries = 3;
            while (tries != 0) {
                if (tries == 1) {
                    System.out.println("This is your last try!");
                }
                System.out.println("Enter password: ");
                input = sc.nextLine();
                if (ADMIN_PASSWORD.equals(input)) {
                    isAdmin = true;
                    break;
                }
                tries--;
            }
        }
        if (isAdmin) {
            System.out.println("You are now logged in as ADMIN.");
        } else {
            System.out.println("You are logged in as passenger.");
        }
    }
}
