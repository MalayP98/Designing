package com.vehical.rental.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.vehical.rental.billing.Bill;
import com.vehical.rental.booking.Booking;

public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private List<Booking> bookings = new ArrayList<>();

    private List<Bill> bills = new ArrayList<>();

    public User(String name, String email, String password) {
        this.id = Long.valueOf(new Random().nextInt(100));
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Booking> bookings() {
        return bookings;
    }

    public Integer rentedVehicalCount() {
        return bookings.size();
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void rentVehical(Booking vehicalInformation) {
        this.bookings.add(vehicalInformation);
    }

    public void returnVehical(Bill bill) {
        this.bills.add(bill);
    }
}
