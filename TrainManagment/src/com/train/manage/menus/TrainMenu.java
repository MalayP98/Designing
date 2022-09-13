package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;
import java.util.ArrayList;
import java.util.List;
import com.train.manage.engine.Engine;
import com.train.manage.repository.StationRepository;
import com.train.manage.repository.TrackRepository;
import com.train.manage.repository.TrainRepository;
import com.train.manage.route.RouteFinder;
import com.train.manage.service.StationService;
import com.train.manage.service.TrackService;
import com.train.manage.service.TrainService;
import com.train.manage.train.Train;
import com.train.manage.train.TrainDTO;

public class TrainMenu {

    private StationService stationService;

    private TrainService trainService;

    private RouteMenu routeMenu;

    private EngineMenu engineMenu;

    public TrainMenu() {
        this.stationService = StationService.getInstance();
        this.trainService = TrainService.getInstance();
        this.routeMenu = new RouteMenu(this.stationService, new RouteFinder());
        this.engineMenu = new EngineMenu();
    }

    public TrainMenu(StationService stationService, RouteMenu routeMenu,
            TrainService trainService) {
        this.routeMenu = routeMenu;
        this.trainService = trainService;
        this.stationService = stationService;
    }

    public TrainDTO getTrainDTO() {
        System.out.println("Enter train name: ");
        String name = SCANNER.next();
        return new TrainDTO(name, routeMenu.findRoute(), engineMenu.selectEngine());
    }

    public void addTrain() {
        Train train = trainService.addTrain(getTrainDTO());
        System.out.println("Train added!, " + train);
    }

    public void updateTrain() {
        System.out.println("Choose the train which you want to update.");
        int trainIndex;
        listAllTrain();
        trainIndex = SCANNER.nextInt();
        trainService.updateTrain(getTrainDTO(), trainService.getTrain(trainIndex));
    }

    public void listAllTrain() {
        List<Train> trains = trainService.getAllTrain();
        for (int i = 0; i < trains.size(); i++) {
            System.out.print(i + 1 + ": " + trains.get(i));
        }
        System.out.println();
    }
}
