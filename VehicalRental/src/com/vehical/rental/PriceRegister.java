package com.vehical.rental;

import java.util.HashMap;
import java.util.Objects;

public class PriceRegister {

    private static PriceRegister INSTANCE = null;

    private HashMap<String, Double> prices = new HashMap<>();

    private PriceRegister() {
    }

    public static PriceRegister getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PriceRegister();
        }
        return INSTANCE;
    }

    public void add(String vehicalNumber, Double price) {
        prices.put(vehicalNumber, price);
    }

    public Double priceForVehical(String vehicalNumber) {
        if (prices.containsKey(vehicalNumber)) {
            return prices.get(vehicalNumber);
        }
        System.out.println("No vehical with number " + vehicalNumber + " found.");
        return null;
    }

    public void discount(String vehicalNumber, Integer discoutPercent) throws Exception {
        Double currentPrice = priceForVehical(vehicalNumber);
        if (Objects.nonNull(currentPrice))
            prices.put(vehicalNumber, currentPrice * (100 - discoutPercent) / 100);
    }
}
