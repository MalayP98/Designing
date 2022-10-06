package com.vehical.rental;

import com.vehical.rental.menus.AppEntry;
import com.vehical.rental.menus.BillMenu;
import com.vehical.rental.menus.VehicalPopulator;
import com.vehical.rental.menus.VehicalRentMenu;
import com.vehical.rental.menus.VehicalReturnMenu;
import com.vehical.rental.vehicaldetails.VehicalFactory;
import com.vehical.rental.vehicaldetails.VehicalInventory;

public class CarRental {

    private Environment environment;

    public CarRental(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) throws Exception {
        CarRental carRental =
                new CarRental(new Environment(new AppEntry(new AccountManager()),
                        new VehicalRentMenu(VehicalInventory.getInstance(), new RentManager()),
                        new VehicalReturnMenu(VehicalInventory.getInstance(), new RentManager()),
                        new VehicalPopulator(VehicalFactory.getInstance(),
                                VehicalInventory.getInstance(), PriceRegister.getInstance()),
                        new BillMenu()));
        carRental.environment.createEnvironment();
        carRental.environment.start();
    }
}
