package com.train.manage;

import static com.train.manage.Constants.SCANNER;
import com.train.manage.initiators.StationInitiator;
import com.train.manage.initiators.TrackInitiator;
import com.train.manage.menus.AdminMenu;
import com.train.manage.menus.EngineMenu;
import com.train.manage.menus.EntryMenu;
import com.train.manage.menus.TrainMenu;
import com.train.manage.repository.EngineRepository;
import com.train.manage.service.AuthService;
import com.train.manage.service.EngineService;

public class Environment {

    private EntryMenu entryMenu;

    private AdminMenu adminMenu;

    private EngineService engineService;

    private static Environment INSTANCE = null;

    private static boolean created = false;

    private Environment() {
        this.entryMenu = new EntryMenu(new AuthService());
        this.adminMenu = new AdminMenu(new TrainMenu(), new EngineMenu());
        this.engineService = new EngineService();
    }

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
        TrackInitiator.createTracks(StationInitiator.getStations());
        engineService.addEngine(Constants.DEFAULT_ENGINE);
        System.out.println("Environment created.");
        created = true;
    }

    public void start() {
        int input;
        while (true) {
            System.out.println("Enter -1 to exit app or 1 to continue.");
            input = SCANNER.nextInt();
            if (input == -1)
                return;
            if (entryMenu.authenticate()) {
                adminMenu.displayMenu();
            }
        }
    }
}
