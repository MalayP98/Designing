package com.vending.machine.error;

public class QuantityOverflowException extends Exception {

    public QuantityOverflowException() {
        super("Not enough item available. Decrease the quantity");
    }
}
