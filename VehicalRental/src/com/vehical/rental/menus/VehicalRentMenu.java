package com.vehical.rental.menus;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.vehical.rental.rentmanager.RentManagerImpl;
import com.vehical.rental.user.User;
import com.vehical.rental.vehicaldetails.Vehical;
import com.vehical.rental.vehicaldetails.VehicalInventory;
import com.vehical.rental.vehicaldetails.VehicalType;

public class VehicalRentMenu extends VehicalOptionsMenu {

    public VehicalRentMenu(VehicalInventory vehicalInventory, RentManagerImpl rentManager) {
        super(vehicalInventory, rentManager);
    }

    public void rentVehical(User user) {
        int option = -1;
        System.out.println("1: Rent Bikes\n2: Rent Cars\n-1: EXIT");
        option = SCANNER.nextInt();
        if (option == -1)
            return;
        Vehical selectedVehical = null;
        switch (option) {
            case 1:
                selectedVehical = selectVehical(VehicalType.TWO_WHEELER);
                break;
            case 2:
                selectedVehical = selectVehical(VehicalType.FOUR_WHEELER);
                break;
            default:
                rentVehical(user);
        }
        if (Objects.nonNull(selectedVehical)) {
            rentManager.rentVehical(user, selectedVehical, new Date(), new Date());
            System.out.println("Vehical rented!");
        }
        return;
    }

    private Vehical selectVehical(VehicalType type) {
        System.out.println("Select vehical you would like to rent(-1 to EXIT): ");
        listVehical(type);
        int vehicalIndex = SCANNER.nextInt();
        if (vehicalIndex == -1) {
            System.out.println("No vehical selected");
            return null;
        }
        vehicalIndex--;
        List<Vehical> vehicals = getVehicalList(type);
        if (vehicalIndex >= vehicals.size()) {
            System.out.println("No such vehical found! Try again.");
            selectVehical(type);
        }
        return vehicals.get(vehicalIndex);
    }

    private List<Vehical> getVehicalList(VehicalType type) {
        return (type.equals(VehicalType.TWO_WHEELER)) ? vehicalInventory.getAllAvailableBikes()
                : vehicalInventory.getAllAvailableCar();
    }

    private void listVehical(VehicalType type) {
        List<Vehical> vehicals = getVehicalList(type);
        if (vehicals.size() == 0) {
            System.out.println("Sorry, no vehical available right now.");
        }
        for (int i = 1; i <= vehicals.size(); i++) {
            System.out.println(i + ": " + vehicals.get(i - 1));
        }
    }
}
