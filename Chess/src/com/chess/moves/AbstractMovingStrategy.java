package com.chess.moves;

import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.Piece;

public abstract class AbstractMovingStrategy implements MovingStrategy {

    protected BoardState boardState;

    protected final int STEP_CONSTRAINT;

    public AbstractMovingStrategy(BoardState boardState, int stepConstraint) {
        this.boardState = boardState;
        this.STEP_CONSTRAINT = stepConstraint;
    }

    public boolean isValidMove(MovableCoordinate from, MovableCoordinate to) {
        if (to.isValid()) {
            if (boardState.getPieceAtCoordinate(from).isBlack()) {
                to = to.reversePerspective();
            }
            return boardState.canMoveTo(to, from);
        }
        return false;
    }
}
