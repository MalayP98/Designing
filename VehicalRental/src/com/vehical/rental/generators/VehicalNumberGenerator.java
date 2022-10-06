package com.vehical.rental.generators;

public class VehicalNumberGenerator {

    public String generateVehicalNumber() {
        StringBuilder vehicalNumberBuilder = new StringBuilder();
        vehicalNumberBuilder.append(RandomElementGenerators.getRandomChar());
        vehicalNumberBuilder.append(RandomElementGenerators.getRandomChar());
        vehicalNumberBuilder.append(" " + (RandomElementGenerators.getRandomInt(10, 99) + " "));
        vehicalNumberBuilder.append(RandomElementGenerators.getRandomChar());
        vehicalNumberBuilder.append(RandomElementGenerators.getRandomChar());
        vehicalNumberBuilder.append(RandomElementGenerators.getRandomInt(1000, 9999));
        return vehicalNumberBuilder.toString();
    }
}
