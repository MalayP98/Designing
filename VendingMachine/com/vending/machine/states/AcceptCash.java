package com.vending.machine.states;

import com.vending.machine.Item;
import com.vending.machine.VendingMachine;

public class AcceptCash extends State {

    public AcceptCash(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void startTransaction() {
        System.out.println("Transaction already in progress.");
    }

    @Override
    public int endTransaction() {
        int returnCash = vendingMachine.getAcceptedCash();
        vendingMachine.addCash(-returnCash);
        vendingMachine.changeState(new ReadyState(vendingMachine));
        System.out.println("Transaction complete.");
        return returnCash;
    }

    @Override
    public void selectItem() {
        System.out.println(vendingMachine.displayInventory());
        vendingMachine.changeState(new DispenseItem(vendingMachine));
    }

    @Override
    public Item dispenseItem(int code, int quantity) {
        System.out.println("No item selected!");
        return null;
    }

    @Override
    public void acceptCash(int cash) {
        vendingMachine.addCash(cash);
    }
}
