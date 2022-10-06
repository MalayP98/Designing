package com.vehical.rental;

import com.vehical.rental.user.User;
import com.vehical.rental.user.UserRegister;

public class AccountManager {

    private UserRegister userRegister;

    public AccountManager() {
        userRegister = UserRegister.getInstance();
    }

    public User signUp(String email, String password) {
        try {
            User user = new User("User" + userRegister.totalUsers(), email, password);
            userRegister.add(user);
            System.out.println("Account created successfully.");
            return user;
        } catch (Exception e) {
            System.out.println("ERROR: Error adding user.");
        }
        return null;
    }

    public User signIn(String email, String password) {
        return userRegister.getUser(email, password);
    }
}
