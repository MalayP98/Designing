package com.train.manage.menus;

import static com.train.manage.Constants.SCANNER;
import com.train.manage.service.AuthService;

public class EntryMenu {

    private AuthService authService;

    public EntryMenu(AuthService authService) {
        this.authService = authService;
    }

    private static boolean LOGGEDIN = false;

    public boolean authenticate() {
        if (LOGGEDIN)
            return logout();
        return login();
    }

    private boolean login() {
        boolean isAdmin = false;
        System.out.println("Login: \nAre you a admin? Press 'Y' for Yes and 'N' for No.");
        String input = SCANNER.next();
        if (input.equals("Y")) {
            isAdmin = authService.login();
        }
        if (isAdmin) {
            System.out.println("You are now logged in as ADMIN.");
            LOGGEDIN = true;
        } else {
            System.out.println("You are logged in as passenger.");
        }
        return isAdmin;
    }

    private boolean logout() {
        LOGGEDIN = false;
        return authService.logout();
    }
}
