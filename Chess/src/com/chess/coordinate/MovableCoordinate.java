package com.chess.coordinate;

public class MovableCoordinate extends AbstractCoordinate {

    public MovableCoordinate(CordinateElement x, CordinateElement y) {
        super(x, y);
    }

    public MovableCoordinate(int x, int y) {
        this(new CordinateElement(x), new CordinateElement(y));
    }

    public MovableCoordinate moveRight() {
        return new MovableCoordinate(this.x, this.y.next());
    }

    public MovableCoordinate moveLeft() {
        return new MovableCoordinate(this.x, this.y.previous());
    }

    public MovableCoordinate moveBackward() {
        return new MovableCoordinate(this.x.previous(), this.y);
    }

    public MovableCoordinate moveForward() {
        return new MovableCoordinate(this.x.next(), this.y);
    }

    public MovableCoordinate moveNorthEast() {
        return this.moveForward().moveRight();
    }

    public MovableCoordinate moveNorthWest() {
        return this.moveForward().moveLeft();
    }

    public MovableCoordinate moveSouthhWest() {
        return this.moveBackward().moveLeft();
    }

    public MovableCoordinate moveSouthEast() {
        return this.moveBackward().moveRight();
    }

    @Override
    public String toString() {
        return "(" + x.getValue() + ", " + y.getValue() + ")";
    }
}
