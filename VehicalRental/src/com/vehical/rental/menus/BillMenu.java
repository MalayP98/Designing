package com.vehical.rental.menus;

import java.util.List;
import java.util.Scanner;
import com.vehical.rental.billing.Bill;
import com.vehical.rental.user.User;

public class BillMenu {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void viewBillMenu(User user) {
        System.out.println("1: View bill for perticular vehical.\n2: View all bills.\n-1: EXIT");
        int option = SCANNER.nextInt();
        switch (option) {
            case -1:
                return;
            case 1:
                viewBillForVehical(user);
                break;
            case 2:
                listAllBills(user);
                break;
            default:
                viewBillMenu(user);
        }
    }

    private void viewBillForVehical(User user) {
        List<Bill> bills = user.getBills();
        if (bills.size() == 0) {
            System.out.println("No bills found.");
            return;
        }
        System.out.println("Select vehical number for which you want to view the bill: ");
        int i = 1;
        for (Bill bill : bills)
            System.out.println(i++ + ": " + bill.getBooking().getVehicalNumber());
        int billIndex = SCANNER.nextInt();
        if (billIndex == -1) {
            System.out.println("No bill found!");
            viewBillForVehical(user);
        }
        billIndex--;
        System.out.println(bills.get(billIndex));
    }

    private void listAllBills(User user) {
        List<Bill> bills = user.getBills();
        if (bills.size() == 0) {
            System.out.println("No bills found.");
            return;
        }
        for (Bill bill : bills)
            System.out.println(bill);
        System.out.println();
    }
}
