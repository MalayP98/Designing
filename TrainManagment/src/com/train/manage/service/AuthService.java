package com.train.manage.service;

import static com.train.manage.Constants.SCANNER;

public class AuthService {

    private static AuthService INSTANCE = null;

    private final String ADMIN_PASSWORD = "admin";

    private AuthService() {
    }

    public static AuthService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthService();
        }
        return INSTANCE;
    }

    public boolean login() {
        boolean isAdmin = false;
        String input;
        int tries = 3;
        while (tries != 0) {
            if (tries == 1) {
                System.out.println("This is your last try!");
            }
            System.out.println("Enter password: ");
            input = SCANNER.next();
            if (ADMIN_PASSWORD.equals(input)) {
                isAdmin = true;
                break;
            }
            tries--;
        }
        return isAdmin;
    }

    public boolean logout() {
        System.out.println("Logged Out. Thank You.");
        return true;
    }
}
