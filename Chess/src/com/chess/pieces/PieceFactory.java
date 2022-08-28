package com.chess.pieces;

import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.MovingStrategy;
import com.chess.moves.MovingStrategyDistributor;

public class PieceFactory {

    private MovingStrategyDistributor movingStrategyFactory;

    public PieceFactory(MovingStrategyDistributor movingStrategyFactory) {
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
