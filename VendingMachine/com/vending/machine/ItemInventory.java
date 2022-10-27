package com.vending.machine;

import java.util.HashMap;
import java.util.Map;
import com.vending.machine.error.QuantityOverflowException;
import com.vending.machine.error.UnknownCodeException;

public class ItemInventory {

    public class ItemQuantityPair {

        private Item item;

        private int count;

        public ItemQuantityPair(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void decreaseCount(int by) {
            count -= by;
        }

        public Item getItem() {
            return item;
        }
    }

    private Map<Integer, ItemQuantityPair> inventory = new HashMap<>();

    private static ItemInventory INSTANCE = null;

    private ItemInventory() {
    }

    public static ItemInventory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemInventory();
        }
        return INSTANCE;
    }

    public void addItem(int code, Item item, int count) {
        if (!inventory.containsKey(code)) {
            inventory.put(code, new ItemQuantityPair(item, count));
        }
    }

    public Item getItem(int code, int count) throws Exception {
        if (inventory.containsKey(code)) {
            ItemQuantityPair itemQuantityPair = inventory.get(code);
            if (count > itemQuantityPair.getCount()) {
                throw new QuantityOverflowException();
            }
            itemQuantityPair.decreaseCount(count);
            return itemQuantityPair.getItem();
        }
        throw new UnknownCodeException();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, ItemQuantityPair> entrySet : inventory.entrySet()) {
            builder.append(entrySet.getKey() + ": (" + entrySet.getValue().getItem()
                    + ", Quantity: " + entrySet.getValue().getCount() + ") \n");
        }
        return builder.toString();
    }

    public int getItemPrice(int code) throws UnknownCodeException {
        if (inventory.containsKey(code)) {
            return inventory.get(code).getItem().getPrice();
        }
        throw new UnknownCodeException();
    }
}
