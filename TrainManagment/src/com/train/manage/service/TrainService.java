package com.train.manage.service;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.TrainRepository;
import com.train.manage.route.Route;
import com.train.manage.train.Train;
import com.train.manage.train.TrainDTO;

public class TrainService {

    private static TrainService INSTANCE = null;

    private StationService stationService;

    private TrainRepository trainRepository;

    private TrackService trackService;

    private TrainService(TrainRepository trainRepository, StationService stationService,
            TrackService trackService) {
        this.stationService = stationService;
        this.trainRepository = trainRepository;
        this.trackService = trackService;
    }

    public static TrainService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrainService(TrainRepository.getInstance(), StationService.getInstance(),
                    TrackService.getInstance());
        }
        return INSTANCE;
    }

    public List<Station> getRoute(List<Integer> routeStationId) {
        List<Station> route = new ArrayList<>();
        for (int stationId : routeStationId) {
            route.add(stationService.getStation(stationId));
        }
        return route;
    }

    public Train addTrain(TrainDTO trainData) {
        Train train = new Train(trainData.getName(), new Route(getRoute(trainData.getRoute())),
                trainData.getEngine(),
                calculateTravelTime(trainData.getEngine().getMaxSpeed(), trainData.getRoute()));
        trainRepository.add(train);
        return train;
    }

    public Train updateTrain(TrainDTO trainData, Train train) {
        if (!trainData.getName().equals(""))
            train.setName(trainData.getName());
        train.setRoute(new Route(getRoute(trainData.getRoute())));
        train.setEngine(trainData.getEngine());
        train.setTravelTime(
                calculateTravelTime(trainData.getEngine().getMaxSpeed(), trainData.getRoute()));
        return train;
    }

    public List<Train> getAllTrain() {
        return trainRepository.getAll();
    }

    public Train getTrain(Integer index) {
        return trainRepository.getAll().get(index - 1);
    }

    private List<Float> calculateTravelTime(int maxSpeed, List<Integer> route) {
        List<Float> travelTime = new ArrayList<>();
        for (int i = 0; i < route.size() - 1; i++) {
            travelTime
                    .add((float) trackService.distance(route.get(i), route.get(i + 1)) / maxSpeed);
        }
        return travelTime;
    }

    public List<Train> getAvailableTrains(int source, int destination) {
        List<Train> availableTrains = new ArrayList<>();
        List<Train> trains = trainRepository.getAll();
        for (Train train : trains) {
            if (isTrainAvailable(train.getRoute().getRoute(), source, destination)) {
                availableTrains.add(train);
            }
        }
        return availableTrains;
    }

    public boolean isTrainAvailable(List<Station> stations, int source, int destination) {
        boolean sourceFound = false, destinationFound = false;
        for (Station station : stations) {
            if (station.getId() == source && !sourceFound) {
                sourceFound = true;
            }
            if (station.getId() == destination && !destinationFound) {
                destinationFound = true;
            }
            if (sourceFound && destinationFound)
                return true;
        }
        return (sourceFound && destinationFound);
    }
}
