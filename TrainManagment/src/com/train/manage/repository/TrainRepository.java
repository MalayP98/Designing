package com.train.manage.repository;

import java.util.ArrayList;
import java.util.List;
import com.train.manage.train.Train;

public class TrainRepository implements Repository<Train> {

    private List<Train> trains = new ArrayList<>();

    @Override
    public boolean add(Train train) {
        return trains.add(train);
    }

    @Override
    public boolean update(int index, Train train) {
        trains.add(index, train);
        return true;
    }

    @Override
    public boolean delete(int index) {
        return (trains.remove(index) != null);
    }

    @Override
    public Train get(int index) {
        return trains.get(index);
    }

    public List<Train> getAll() {
        return trains;
    }

    public Train findTrainByName(String name) {
        for (Train train : trains) {
            if (name.equals(train.getName()))
                return train;
        }
        return null;
    }
}
