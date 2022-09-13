package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;
import java.util.ArrayList;
import java.util.List;
import com.train.manage.service.StationService;
import com.train.manage.service.TrainService;
import com.train.manage.train.Train;

public class PassengerMenu {

    private StationMenu stationMenu;

    private TrainService trainService;

    public PassengerMenu() {
        this.stationMenu = new StationMenu(StationService.getInstance());
        this.trainService = TrainService.getInstance();
    }

    public void bookTicket() {
        System.out.println("Book ticket: ");
        stationMenu.listAllStations();
        List<Train> availableTrain = new ArrayList<>();
        do {
            System.out.println("Enter source: ");
            int source = SCANNER.nextInt();
            System.out.println("Enter destination: ");
            int destination = SCANNER.nextInt();
            availableTrain = trainService.getAvailableTrains(source, destination);
            if (availableTrain.size() == 0) {
                System.out.println(
                        "Sorry no trains are available for the selected route. Enter -1 to exit or 1 to search any other route");
                int exit = SCANNER.nextInt();
                if (exit == -1)
                    return;
            } else
                break;
        } while (true);
        System.out.println("Which train would you like to travel in?");
        int trainSelection = SCANNER.nextInt();
        if (trainSelection > 0 && trainSelection <= availableTrain.size()) {
            System.out.println("Ticket booked! Safe journey.");
        } else {
            System.out.println("No such train found. Enter 1 to try again or -1 to exit.");
            int exit = SCANNER.nextInt();
            if (exit == -1)
                return;
        }
    }
}
