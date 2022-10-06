package com.vehical.rental.vehicaldetails;

import java.util.Date;
import java.util.Objects;

public class Vehical {

    private String vehicalNumber;

    private String brand;

    private Date registrationDate;

    private VehicalType type;

    private String name;

    private Integer kilometersDriven = 0;

    private Integer topSpeed = 0;

    private Integer mileage = 0;

    private VehicalStatus status;

    public Vehical(String name, String vehicalNumber, String brand, VehicalType type)
            throws Exception {
        if (Objects.isNull(vehicalNumber) || vehicalNumber.isBlank()) {
            throw new Exception("Vehical number cannot be empty.");
        }
        this.name = name;
        this.brand = brand;
        this.vehicalNumber = vehicalNumber;
        this.type = type;
        this.status = VehicalStatus.ACTIVE;
    }

    public String getBrand() {
        return brand;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String vehicalNumber() {
        return vehicalNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getKilometersDriven() {
        return kilometersDriven;
    }

    public void setTopSpeed(Integer topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getTopSpeed() {
        return topSpeed;
    }

    public Integer getMileage() {
        return mileage;
    }

    public boolean isCar() {
        return VehicalType.FOUR_WHEELER.equals(type);
    }

    public boolean isBike() {
        return VehicalType.TWO_WHEELER.equals(type);
    }

    public Integer increaseKilometersDriven(Integer by) {
        this.kilometersDriven += by;
        return this.kilometersDriven;
    }

    public void toggleStatus() {
        if (status.equals(VehicalStatus.ACTIVE))
            status = VehicalStatus.INACTIVE;
        else
            status = VehicalStatus.ACTIVE;
    }

    public boolean isActive() {
        return VehicalStatus.ACTIVE.equals(status);
    }

    @Override
    public String toString() {
        return vehicalNumber + ": " + brand + "-" + name;
    }
}
