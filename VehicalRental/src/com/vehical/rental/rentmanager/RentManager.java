package com.vehical.rental.rentmanager;

import java.util.Date;
import com.vehical.rental.user.User;
import com.vehical.rental.vehicaldetails.Vehical;

public interface RentManager {

    public boolean rentVehical(User user, Vehical vehical, Date from, Date till);

    public boolean returnVehical(User user, Vehical vehical, Date returDate);
}
