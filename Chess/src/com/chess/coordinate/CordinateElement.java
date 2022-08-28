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
        else if (this.value + 1 > 8)
            return new CordinateElement(-1);
        return new CordinateElement(this.value + 1);
    }

    public CordinateElement previous() {
        if (this.value == -1)
            return this;
        else if (this.value - 1 < 1)
            return new CordinateElement(-1);
        return new CordinateElement(this.value - 1);
    }
}
