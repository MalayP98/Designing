package com.vending.machine.states;

import com.vending.machine.Item;
import com.vending.machine.VendingMachine;

public class ReadyState extends State {

    public ReadyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void startTransaction() {
        System.out.println("Transaction started.");
        vendingMachine.changeState(new AcceptCash(vendingMachine));
    }

    @Override
    public int endTransaction() {
        System.out.println("No transaction in progress!");
        return -1;
    }

    @Override
    public void selectItem() {
        System.out.println("Add money to start a transaction.");
    }

    @Override
    public Item dispenseItem(int code, int quantity) {
        System.out.println("No cash detected.");
        return null;
    }

    @Override
    public void acceptCash(int cash) {
        System.out.println("Start a transaction to make machine accept cash.");
    }
}
