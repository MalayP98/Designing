package com.vehical.rental.user;

import java.util.ArrayList;
import java.util.List;
import com.vehical.rental.booking.Booking;

public class UserService {

    public List<Booking> getActiveBooking(User user) {
        List<Booking> activeBookings = new ArrayList<>();
        for (Booking booking : user.bookings()) {
            if (booking.isInprogress() || booking.isScheduled())
                activeBookings.add(booking);
        }
        return activeBookings;
    }
}
