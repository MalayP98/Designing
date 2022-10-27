package com.vending.machine;

public class Driver {

    public void populateInventory() {
        ItemInventory inventory = ItemInventory.getInstance();

        // SODA
        inventory.addItem(101, new Item(ItemType.SODA, 30, "Coke"), 5);
        inventory.addItem(102, new Item(ItemType.SODA, 25, "Pepsi"), 5);
        inventory.addItem(103, new Item(ItemType.SODA, 35, "Sprite"), 5);

        // JUICE
        inventory.addItem(104, new Item(ItemType.JUICE, 10, "Tropicana"), 7);
        inventory.addItem(105, new Item(ItemType.JUICE, 10, "Real"), 4);
    }

    public void run() throws Exception {

        populateInventory();

        VendingMachine vendingMachine = new VendingMachine();

        // Start Transaction
        vendingMachine.getState().startTransaction();

        // Entring low amount
        vendingMachine.getState().acceptCash(25);

        // Select item
        vendingMachine.getState().selectItem();
        vendingMachine.getState().dispenseItem(101, 1);

        // Entering remaining amount
        vendingMachine.getState().acceptCash(5);

        // Select item
        vendingMachine.getState().selectItem();
        vendingMachine.getState().dispenseItem(101, 1);
    }
}
