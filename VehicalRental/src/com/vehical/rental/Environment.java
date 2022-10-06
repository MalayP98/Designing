package com.vehical.rental;

import java.util.Objects;
import java.util.Scanner;
import com.vehical.rental.generators.RandomElementGenerators;
import com.vehical.rental.menus.AppEntry;
import com.vehical.rental.menus.BillMenu;
import com.vehical.rental.menus.VehicalPopulator;
import com.vehical.rental.menus.VehicalRentMenu;
import com.vehical.rental.menus.VehicalReturnMenu;
import com.vehical.rental.user.User;

public class Environment {

    private AppEntry appEntry;

    private VehicalRentMenu vehicalRentMenu;

    private VehicalReturnMenu vehicalReturnMenu;

    private VehicalPopulator vehicalPopulator;

    private BillMenu billMenu;

    private static final Scanner SCANNER = new Scanner(System.in);

    public Environment(AppEntry appEntry, VehicalRentMenu vehicalRentMenu,
            VehicalReturnMenu vehicalReturnMenu, VehicalPopulator vehicalPopulator,
            BillMenu billMenu) {
        this.appEntry = appEntry;
        this.vehicalRentMenu = vehicalRentMenu;
        this.vehicalReturnMenu = vehicalReturnMenu;
        this.vehicalPopulator = vehicalPopulator;
        this.billMenu = billMenu;
    }

    public void createEnvironment() {
        try {
            vehicalPopulator.populateVehicals(RandomElementGenerators.getRandomInt(10));
            System.out.println("Environment created!");
        } catch (Exception e) {
            System.out.println("ERROR: Error creating environment.");
        }
    }

    public void start() {
        int option = -1;
        User user = appEntry.enter();
        if (Objects.isNull(user))
            return;
        while (true) {
            System.out.println("1: Rent\n2: Return\n3: Show bills\n-1: EXIT");
            option = SCANNER.nextInt();
            switch (option) {
                case -1:
                    start();
                    return;
                case 1:
                    vehicalRentMenu.rentVehical(user);
                    break;
                case 2:
                    vehicalReturnMenu.returnVehical(user);
                    break;
                case 3:
                    billMenu.viewBillMenu(user);
                    break;
            }
        }
    }
}
