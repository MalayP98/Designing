package com.vehical.rental.vehicaldetails;

public class VehicalInspector {

    public boolean inspect(Vehical vehical) {
        if (vehical != null) {
            return (vehical.getKilometersDriven() >= 0 && (vehical.isBike() || vehical.isCar())
                    && vehical.getMileage() >= 10 && vehical.getTopSpeed() >= 20);
        }
        return false;
    }
}
