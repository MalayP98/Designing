package com.vehical.rental.menus;

import java.util.Scanner;
import com.vehical.rental.RentManager;
import com.vehical.rental.vehicaldetails.VehicalInventory;

public abstract class VehicalOptionsMenu {

    protected static final Scanner SCANNER = new Scanner(System.in);

    protected VehicalInventory vehicalInventory;

    protected RentManager rentManager;

    public VehicalOptionsMenu(VehicalInventory vehicalInventory, RentManager rentManager) {
        this.vehicalInventory = vehicalInventory;
        this.rentManager = rentManager;
    }
}
