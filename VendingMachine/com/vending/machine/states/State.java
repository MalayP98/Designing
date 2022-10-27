package com.vending.machine.states;

import com.vending.machine.Item;
import com.vending.machine.VendingMachine;

public abstract class State {

    protected VendingMachine vendingMachine;

    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void startTransaction();

    public abstract int endTransaction();

    public abstract void selectItem();

    public abstract Item dispenseItem(int code, int quantity) throws Exception;

    public abstract void acceptCash(int cash);

}
