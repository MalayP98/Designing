package com.vehical.rental.billing;

import java.util.Date;
import java.util.UUID;
import com.vehical.rental.booking.Booking;

public class Bill {

    private String orderId;

    private Booking booking;

    private Date returnDate;

    private Double finalAmount;

    public Bill(Booking booking, Date returnDate, Double finalAmount) {
        this.orderId = UUID.randomUUID().toString().substring(0, 10).replace("-", "");
        this.booking = booking;
        this.returnDate = returnDate;
        this.finalAmount = finalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public Booking getBooking() {
        return booking;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("******************* BILL ********************\n");
        builder.append("Order ID: " + orderId + "\n");
        builder.append("Vehical rented: " + booking.getVehicalNumber() + "\n");
        builder.append("Rented from " + booking.getRentDate().toString() + "\n");
        builder.append("Rented till: " + booking.getReturnDate().toString() + "\n");
        builder.append("Actual return date: " + returnDate.toString() + "\n");
        builder.append("Final amount: " + finalAmount + "\n");
        builder.append("*********************************************\n");
        return builder.toString();
    }
}
