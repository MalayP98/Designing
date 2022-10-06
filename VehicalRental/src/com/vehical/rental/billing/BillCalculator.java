package com.vehical.rental.billing;

import java.util.Date;
import com.vehical.rental.PriceRegister;
import com.vehical.rental.booking.Booking;

public class BillCalculator {

    private static PriceRegister priceRegister = PriceRegister.getInstance();

    private static final Double GST = 18.0;

    private static final Double DUE_DAY_EXTENSION_CHARGES = 5.0;

    public static Bill caclculate(Booking reservation, Date returnDate) {
        Double finalAmount = caculateTotalAmount(reservation, returnDate)
                + caculateDueDateExtensionCharges(reservation, returnDate);
        return new Bill(reservation, returnDate, calculateGST(finalAmount));
    }

    private static Double caculateTotalAmount(Booking reservation, Date returnDate) {
        Double vehicalRentPrice = priceRegister.priceForVehical(reservation.getVehicalNumber());
        return vehicalRentPrice
                * (reservation.getRentDate().compareTo(reservation.getReturnDate()));
    }

    private static Double caculateDueDateExtensionCharges(Booking reservation, Date returnDate) {
        Double vehicalRentPrice = priceRegister.priceForVehical(reservation.getVehicalNumber());
        if (reservation.getReturnDate().compareTo(returnDate) > 0) {
            Double increasedInVehicalRentPrice = (100 + DUE_DAY_EXTENSION_CHARGES) / 100;
            return vehicalRentPrice * ((Math.pow(increasedInVehicalRentPrice,
                    reservation.getReturnDate().compareTo(returnDate)) - 1)
                    / (increasedInVehicalRentPrice - 1) - 1);
        }
        return 0.0;
    }

    private static Double calculateGST(Double amount) {
        return amount * ((100 + GST) / 100);
    }
}
