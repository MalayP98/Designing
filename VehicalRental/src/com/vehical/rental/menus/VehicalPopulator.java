package com.vehical.rental.menus;

import com.vehical.rental.PriceRegister;
import com.vehical.rental.generators.RandomElementGenerators;
import com.vehical.rental.vehicaldetails.Vehical;
import com.vehical.rental.vehicaldetails.VehicalFactory;
import com.vehical.rental.vehicaldetails.VehicalInventory;
import com.vehical.rental.vehicaldetails.VehicalType;

public class VehicalPopulator {

    private VehicalFactory vehicalFactory;

    private VehicalInventory vehicalInventory;

    private PriceRegister priceRegister;

    private static final Double MIN_PRICE = 1000.0;

    private static final Double MAX_PRICE = 7000.0;

    public VehicalPopulator(VehicalFactory vehicalFactory, VehicalInventory vehicalInventory,
            PriceRegister priceRegister) {
        this.vehicalFactory = vehicalFactory;
        this.vehicalInventory = vehicalInventory;
        this.priceRegister = priceRegister;
    }

    public void populateVehicals(int count) throws Exception {
        while (count != 0) {
            Vehical car = vehicalFactory.createVehical(VehicalType.FOUR_WHEELER);
            vehicalInventory.registerCar(car);
            priceRegister.add(car.vehicalNumber(),
                    RandomElementGenerators.getRandomDouble(MIN_PRICE, MAX_PRICE));

            Vehical bike = vehicalFactory.createVehical(VehicalType.TWO_WHEELER);
            vehicalInventory.registerBike(bike);
            priceRegister.add(bike.vehicalNumber(),
                    RandomElementGenerators.getRandomDouble(MIN_PRICE, MAX_PRICE));
            count--;
        }
    }
}
