package com.vehical.rental.vehicaldetails;

import com.vehical.rental.generators.RandomElementGenerators;
import com.vehical.rental.generators.VehicalNumberGenerator;

public class VehicalFactory {

    private static VehicalFactory INSTANCE = null;

    private VehicalNumberGenerator vehicalNumberGenerator;

    private static final String BRAND = "Brand";

    private static final String NAME = "Name";

    private VehicalFactory(VehicalNumberGenerator vehicalNumberGenerator) {
        this.vehicalNumberGenerator = vehicalNumberGenerator;
    }

    public static VehicalFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehicalFactory(new VehicalNumberGenerator());
        }
        return INSTANCE;
    }

    public Vehical createVehical(VehicalType type) throws Exception {
        Vehical vehical = new Vehical(NAME + RandomElementGenerators.getRandomInt(100),
                vehicalNumberGenerator.generateVehicalNumber(),
                BRAND + RandomElementGenerators.getRandomInt(100), type);
        vehical.setMileage(RandomElementGenerators.getRandomInt(15, 30));
        vehical.setTopSpeed(RandomElementGenerators.getRandomInt(20, 30));
        return vehical;
    }
}
