package com.vehical.rental.booking;

import java.util.Date;

public class Booking {

    private String vehicalNumber;

    private Date rentDate;

    private Date returnDate;

    private Integer kilometersDriven;

    private BookingStatus status;

    public Booking(String vehicalNumber, Date rentDate, Date returnDate, BookingStatus status) {
        this.vehicalNumber = vehicalNumber;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public void setKilometersDriven(Integer kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
    }

    public String getVehicalNumber() {
        return vehicalNumber;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Integer getKilometersDriven() {
        return kilometersDriven;
    }

    public void setResvationStatus(BookingStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return BookingStatus.COMPLETE.equals(status);
    }

    public boolean isInprogress() {
        return BookingStatus.INPROGRESS.equals(status);
    }

    public boolean isCanclled() {
        return BookingStatus.CANCLE.equals(status);
    }

    public boolean isScheduled() {
        return BookingStatus.SCHEDULED.equals(status);
    }
}
