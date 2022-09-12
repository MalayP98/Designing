package com.train.manage;

import com.train.manage.repository.StationRepository;
import com.train.manage.route.RouteFinder;

class TrainManagementApp {
    public static void main(String[] args) {
        Environment env = Environment.getInstance();
        env.create(15);
        env.start();
    }
}
