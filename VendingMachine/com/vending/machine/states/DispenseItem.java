package com.vending.machine.states;

import com.vending.machine.Item;
import com.vending.machine.VendingMachine;
import com.vending.machine.error.QuantityOverflowException;
import com.vending.machine.error.UnknownCodeException;

public class DispenseItem extends State {

    public DispenseItem(VendingMachine vendingMachine) {
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
        System.out.println("Items already selected!");
    }

    @Override
    public Item dispenseItem(int code, int quantity) throws Exception {
        Item dispenseItem = null;
        try {
            if (vendingMachine.getItemPrice(code) * quantity > vendingMachine.getAcceptedCash()) {
                System.out.println("No enough cash. Enter more cash or cancle transaction.");
                vendingMachine.changeState(new AcceptCash(vendingMachine));
            } else {
                dispenseItem = vendingMachine.getItem(code, quantity);
                vendingMachine.addCash(-(dispenseItem.getPrice() * quantity));
                vendingMachine.addToTotalCash(dispenseItem.getPrice() * quantity);
                System.out.println("Thank you! Item dispensed.");
                endTransaction();
            }
        } catch (QuantityOverflowException e) {
            System.out.println(quantity + " peices not available for item " + code
                    + ". Try with less quantity.");
        } catch (UnknownCodeException e) {
            System.out.println("No item found with given code. Try again with a valid code.");
        }
        return dispenseItem;
    }

    @Override
    public void acceptCash(int cash) {
        System.out.println("Canot accept cash.");
    }
}
