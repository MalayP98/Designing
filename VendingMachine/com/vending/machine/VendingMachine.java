package com.vending.machine;

import com.vending.machine.error.UnknownCodeException;
import com.vending.machine.states.ReadyState;
import com.vending.machine.states.State;

public class VendingMachine {

    private ItemInventory itemInventory;

    private State state;

    private int currentCash = 0;

    private int totalCash = 0;

    public VendingMachine() {
        this.itemInventory = ItemInventory.getInstance();
        this.state = new ReadyState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void addCash(int cash) {
        currentCash += cash;
    }

    public void addToTotalCash(int cash) {
        totalCash += cash;
    }

    public int getAcceptedCash() {
        return currentCash;
    }

    public String displayInventory() {
        return itemInventory.toString();
    }

    public Item getItem(int code, int quantity) throws Exception {
        return itemInventory.getItem(code, quantity);
    }

    public int getItemPrice(int code) throws UnknownCodeException {
        return itemInventory.getItemPrice(code);
    }
}
