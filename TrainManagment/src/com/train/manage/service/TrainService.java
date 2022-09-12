package com.train.manage.service;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.Station;
import com.train.manage.repository.TrainRepository;
import com.train.manage.route.Route;
import com.train.manage.train.Train;
import com.train.manage.train.TrainDTO;

public class TrainService {

    private StationService stationService;

    private TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository, StationService stationService) {
        this.stationService = stationService;
        this.trainRepository = trainRepository;
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
                trainData.getEngine());
        trainRepository.add(train);
        return train;
    }

    public Train updateTrain(TrainDTO trainData, Train train) {
        if (!trainData.getName().equals(""))
            train.setName(trainData.getName());
        if (trainData.getRoute().size() < 2)
            train.setRoute(new Route(getRoute(trainData.getRoute())));
        return train;
    }

    public List<Train> getAllTrain() {
        return trainRepository.getAll();
    }

    public Train getTrain(Integer index) {
        return trainRepository.getAll().get(index - 1);
    }
}
