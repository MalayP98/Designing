package com.vehical.rental;

import com.vehical.rental.menus.AppEntry;
import com.vehical.rental.menus.BillMenu;
import com.vehical.rental.menus.VehicalPopulator;
import com.vehical.rental.menus.VehicalRentMenu;
import com.vehical.rental.menus.VehicalReturnMenu;
import com.vehical.rental.rentmanager.RentManagerImpl;
import com.vehical.rental.user.UserService;
import com.vehical.rental.vehicaldetails.VehicalFactory;
import com.vehical.rental.vehicaldetails.VehicalInventory;

public class CarRental {

    public static void main(String[] args) {
        run(new Environment(new AppEntry(new AccountManager()),
                new VehicalRentMenu(VehicalInventory.getInstance(), new RentManagerImpl()),
                new VehicalReturnMenu(VehicalInventory.getInstance(), new RentManagerImpl(),
                        new UserService()),
                new VehicalPopulator(VehicalFactory.getInstance(), VehicalInventory.getInstance(),
                        PriceRegister.getInstance()),
                new BillMenu()));
    }

    public static void run(Environment environment) {
        environment.createEnvironment();
        environment.start();
    }
}
