package com.vehical.rental.rentmanager;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.vehical.rental.billing.BillCalculator;
import com.vehical.rental.booking.Booking;
import com.vehical.rental.booking.BookingStatus;
import com.vehical.rental.user.User;
import com.vehical.rental.vehicaldetails.Vehical;

public class RentManagerImpl implements RentManager {

    @Override
    public boolean rentVehical(User user, Vehical vehical, Date from, Date till) {
        if (Objects.nonNull(user) && Objects.nonNull(vehical) && from.compareTo(new Date()) >= 0
                && till.compareTo(from) >= 0) {
            BookingStatus status = (from.compareTo(new Date()) == 0) ? BookingStatus.INPROGRESS
                    : BookingStatus.SCHEDULED;
            vehical.toggleStatus();
            user.rentVehical(new Booking(vehical.vehicalNumber(), from, till, status));
        }
        return false;
    }

    @Override
    public boolean returnVehical(User user, Vehical vehical, Date returnDate) {
        Booking returnVehicalBooking = getBookingForVehical(user.bookings(), vehical);
        if (Objects.nonNull(returnVehicalBooking)) {
            if (returnVehicalBooking.isInprogress())
                returnVehicalBooking.setResvationStatus(BookingStatus.COMPLETE);
            else if (returnVehicalBooking.isScheduled())
                returnVehicalBooking.setResvationStatus(BookingStatus.CANCLE);
            user.returnVehical(BillCalculator.caclculate(returnVehicalBooking, returnDate));
            vehical.toggleStatus();
            return true;
        }
        return false;
    }

    private Booking getBookingForVehical(List<Booking> bookings, Vehical vehical) {
        for (Booking booking : bookings) {
            if (booking.getVehicalNumber().equals(vehical.vehicalNumber())) {
                return booking;
            }
        }
        return null;
    }
}
