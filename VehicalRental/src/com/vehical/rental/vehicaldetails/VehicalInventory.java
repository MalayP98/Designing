package com.vehical.rental.vehicaldetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicalInventory {

    private static VehicalInventory INSTANCE = null;

    private HashMap<VehicalType, List<Vehical>> vehicalsByType = new HashMap<>() {
        {
            put(VehicalType.TWO_WHEELER, new ArrayList<>());
            put(VehicalType.FOUR_WHEELER, new ArrayList<>());
        }
    };

    private HashMap<String, Vehical> vehicalsByVechicalNumber = new HashMap<>();

    private VehicalInspector inspector;

    private VehicalInventory(VehicalInspector inspector) {
        this.inspector = inspector;
    }

    public static VehicalInventory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehicalInventory(new VehicalInspector());
        }
        return INSTANCE;
    }

    public void registerCar(Vehical vehical) {
        if (vehical.isCar()) {
            registerVehical(vehical);
        } else
            System.out.println("ERROR: Unable to register vehical.");
    }

    public void registerBike(Vehical vehical) {
        if (vehical.isBike()) {
            registerVehical(vehical);
        } else
            System.out.println("ERROR: Unable to register vehical.");
    }

    private void registerVehical(Vehical vehical) {
        if (inspector.inspect(vehical)) {
            if (vehical.isCar())
                vehicalsByType.get(VehicalType.FOUR_WHEELER).add(vehical);
            else if (vehical.isBike())
                vehicalsByType.get(VehicalType.TWO_WHEELER).add(vehical);
            vehicalsByVechicalNumber.put(vehical.vehicalNumber(), vehical);
        } else
            System.out.println("ERROR: Unable to register vehical.");
    }

    public Vehical getVehicalByVehicalNumber(String vehicalNumber) {
        if (vehicalsByVechicalNumber.containsKey(vehicalNumber)) {
            return vehicalsByVechicalNumber.get(vehicalNumber);
        }
        System.out.println("ERROR: No vehical found by number " + vehicalNumber);
        return null;
    }

    public List<Vehical> getAllBikes() {
        return vehicalsByType.get(VehicalType.TWO_WHEELER);
    }

    public List<Vehical> getAllCars() {
        return vehicalsByType.get(VehicalType.FOUR_WHEELER);
    }

    public List<Vehical> getAllAvailableBikes() {
        List<Vehical> bikes = getAllBikes();
        List<Vehical> availableBikes = new ArrayList<>();
        for (Vehical bike : bikes) {
            if (bike.isActive())
                availableBikes.add(bike);
        }
        return availableBikes;
    }

    public List<Vehical> getAllAvailableCar() {
        List<Vehical> cars = getAllCars();
        List<Vehical> availableCars = new ArrayList<>();
        for (Vehical car : cars) {
            if (car.isActive())
                availableCars.add(car);
        }
        return availableCars;
    }
}
