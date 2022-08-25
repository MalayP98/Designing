package com.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.MovingStrategy;

public class Piece {

    private MovableCoordinate currentCoordinate;

    private List<MovingStrategy> movingStrategies;

    private PieceType pieceType;

    private PieceColor pieceColor;

    public Piece(MovableCoordinate currentCoordinate, PieceType pieceType, PieceColor pieceColor) {
        this.currentCoordinate = currentCoordinate;
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.movingStrategies = new ArrayList<>();
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public MovableCoordinate getCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(MovableCoordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public void addMovingStartegy(MovingStrategy movingStrategy) {
        movingStrategies.add(movingStrategy);
    }

    public List<MovableCoordinate> getMoves() {
        List<MovableCoordinate> allMoves = new ArrayList<>();
        for (MovingStrategy movingStrategy : movingStrategies) {
            allMoves.addAll(movingStrategy.getMoves(currentCoordinate));
        }
        return allMoves;
    }
}
