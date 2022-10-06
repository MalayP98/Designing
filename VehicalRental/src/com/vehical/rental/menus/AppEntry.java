package com.vehical.rental.menus;

import java.util.Objects;
import java.util.Scanner;
import com.vehical.rental.AccountManager;
import com.vehical.rental.user.User;

public class AppEntry {

    private AccountManager accountManager;

    private static final Scanner SCANNER = new Scanner(System.in);

    public AppEntry(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public User enter() {
        System.out.println("1: LOGIN\n2: SIGNUP\n-1:EXIT");
        int option = SCANNER.nextInt();
        User user = null;
        switch (option) {
            case -1:
                return null;
            case 1:
                user = login();
                break;
            case 2:
                user = signup();
                break;
        }
        if (Objects.isNull(user))
            return enter();
        return user;
    }

    public User login() {
        String username = askUsername();
        String password = askPassword();
        return accountManager.signIn(username, password);
    }

    public User signup() {
        String username = askUsername();
        String password = askPassword();
        return accountManager.signUp(username, password);
    }

    private String askUsername() {
        System.out.print("Name: ");
        String username = SCANNER.next();
        return username;
    }

    private String askPassword() {
        System.out.print("Password: ");
        String password = SCANNER.next();
        return password;
    }

}
