package com.chess.coordinate;

public class CordinateElement {

    private int value;

    public CordinateElement(int value) {
        if (value < 1 || value > 8) {
            this.value = -1;
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public CordinateElement next() {
        if (this.value == -1)
            return this;
        return new CordinateElement(this.value + 1);
    }

    public CordinateElement previous() {
        return new CordinateElement(this.value - 1);
    }
}
