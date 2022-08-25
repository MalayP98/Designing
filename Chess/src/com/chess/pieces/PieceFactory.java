package com.chess.pieces;

import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.MovingStrategy;
import com.chess.moves.MovingStrategyFactory;

public class PieceFactory {

    private MovingStrategyFactory movingStrategyFactory;

    public PieceFactory(MovingStrategyFactory movingStrategyFactory) {
        this.movingStrategyFactory = movingStrategyFactory;
    }

    public Piece createPiece(MovableCoordinate coordinate, PieceType type, PieceColor color) {
        Piece piece = new Piece(coordinate, type, color);
        for (MovingStrategy movingStrategy : movingStrategyFactory.getMovingStrategyFor(type)) {
            piece.addMovingStartegy(movingStrategy);
        }
        return piece;
    }
}
