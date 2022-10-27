package com.vending.machine.error;

public class UnknownCodeException extends Exception {

    public UnknownCodeException() {
        super("No item available by this code.");
    }
}
