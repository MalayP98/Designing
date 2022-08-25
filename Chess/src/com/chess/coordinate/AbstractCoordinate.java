package com.chess.coordinate;

public abstract class AbstractCoordinate {

    protected CordinateElement x;

    protected CordinateElement y;

    public AbstractCoordinate(CordinateElement x, CordinateElement y) {
        if (x.getValue() == -1 || y.getValue() == -1) {
            this.x = new CordinateElement(-1);
            this.y = new CordinateElement(-1);
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public CordinateElement getX() {
        return x;
    }

    public CordinateElement getY() {
        return y;
    }

    public boolean isValid() {
        return (x.getValue() != -1 && y.getValue() != -1);
    }
}
