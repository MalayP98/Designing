package com.vending.machine;

public class Item {

    private Long itemId;

    private ItemType itemType;

    private int price;

    private String name;

    public Item(ItemType itemType, int price, String name) {
        this.itemType = itemType;
        this.price = price;
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + name);
        builder.append(", Price: " + price);
        return builder.toString();
    }
}
