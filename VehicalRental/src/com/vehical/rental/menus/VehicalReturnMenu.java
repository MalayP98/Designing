package com.vehical.rental.menus;

import java.util.ArrayList;
import java.util.List;
import com.vehical.rental.RentManager;
import com.vehical.rental.booking.Booking;
import com.vehical.rental.user.User;
import com.vehical.rental.vehicaldetails.VehicalInventory;

public class VehicalReturnMenu extends VehicalOptionsMenu {

    public VehicalReturnMenu(VehicalInventory vehicalInventory, RentManager rentManager) {
        super(vehicalInventory, rentManager);
    }

    public void returnVehical(User user) {
        System.out.println("Select the vehical which you want to return(-1 to exit): ");
        int bookingIndex = -1;
        listBookedVehicals(user);
        bookingIndex = SCANNER.nextInt();
        if (bookingIndex == -1)
            return;
        bookingIndex--;
        List<String> bookedVehicalNumbers = getBookedVehicals(user);
        if (bookingIndex >= bookedVehicalNumbers.size())
            returnVehical(user);
        rentManager.returnVehical(user,
                vehicalInventory.getVehicalByVehicalNumber(bookedVehicalNumbers.get(bookingIndex)));
    }

    private List<String> getBookedVehicals(User user) {
        List<Booking> bookings = user.bookings();
        List<String> bookedVehicalNumbers = new ArrayList<>();
        for (Booking booking : bookings)
            bookedVehicalNumbers.add(booking.getVehicalNumber());
        return bookedVehicalNumbers;
    }

    private void listBookedVehicals(User user) {
        List<String> bookedVehicalNumbers = getBookedVehicals(user);
        int i = 1;
        for (String bookedVehicalNumber : bookedVehicalNumbers)
            System.err.println(
                    i + ": " + vehicalInventory.getVehicalByVehicalNumber(bookedVehicalNumber));
    }
}
