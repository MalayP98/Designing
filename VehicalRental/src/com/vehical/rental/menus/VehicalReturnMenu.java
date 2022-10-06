package com.vehical.rental.menus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.vehical.rental.booking.Booking;
import com.vehical.rental.rentmanager.RentManagerImpl;
import com.vehical.rental.user.User;
import com.vehical.rental.user.UserService;
import com.vehical.rental.vehicaldetails.VehicalInventory;

public class VehicalReturnMenu extends VehicalOptionsMenu {

    private UserService userService;

    public VehicalReturnMenu(VehicalInventory vehicalInventory, RentManagerImpl rentManager,
            UserService userService) {
        super(vehicalInventory, rentManager);
        this.userService = userService;
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
                vehicalInventory.getVehicalByVehicalNumber(bookedVehicalNumbers.get(bookingIndex)),
                new Date());
    }

    private List<String> getBookedVehicals(User user) {
        List<Booking> activeBookings = userService.getActiveBooking(user);
        List<String> bookedVehicalNumbers = new ArrayList<>();
        for (Booking booking : activeBookings)
            bookedVehicalNumbers.add(booking.getVehicalNumber());
        return bookedVehicalNumbers;
    }

    private void listBookedVehicals(User user) {
        List<String> bookedVehicalNumbers = getBookedVehicals(user);
        int i = 1;
        for (String bookedVehicalNumber : bookedVehicalNumbers)
            System.out.println(
                    i++ + ": " + vehicalInventory.getVehicalByVehicalNumber(bookedVehicalNumber));
    }
}
