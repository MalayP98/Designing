package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;
import java.util.ArrayList;
import java.util.List;
import com.train.manage.route.RouteFinder;
import com.train.manage.service.StationService;

public class RouteMenu {

    private StationMenu stationMenu;

    private StationService stationService;

    private RouteFinder finder;

    public RouteMenu(StationService stationService, RouteFinder finder) {
        this.stationService = stationService;
        this.finder = finder;
        this.stationMenu = new StationMenu(this.stationService);
    }

    public List<Integer> findRoute() {
        System.out.println("Decide route for train:");
        int source = -1, destination = -1;
        stationMenu.listAllStations();
        List<List<Integer>> routes = new ArrayList<>();
        do {
            System.out.println("Select source: ");
            source = SCANNER.nextInt();
            System.out.println("Select destination: ");
            destination = SCANNER.nextInt();
            routes = finder.find(stationService.getStation(source),
                    stationService.getStation(destination));
            if (routes.size() == 0) {
                System.out
                        .println("No routes found for selected source and destination. Try again!");
            } else
                break;
        } while (true);

        for (int i = 1; i <= routes.size(); i++) {
            System.out.print(i + ": ");
            for (Integer stationId : routes.get(i - 1)) {
                System.out.print(stationService.getStation(stationId) + " ");
            }
            System.out.println();
        }
        int routeSelection;
        System.out.println("Which route you want to select?");
        routeSelection = SCANNER.nextInt();
        return routes.get(routeSelection - 1);
    }

}
