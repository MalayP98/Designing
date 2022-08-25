package com.chess.moves;

import com.chess.board.BoardState;

public abstract class AbstractMovingStrategy implements MovingStrategy {

    protected BoardState boardState;

    protected final int STEP_CONSTRAINT;

    public AbstractMovingStrategy(BoardState boardState, int stepConstraint) {
        this.boardState = boardState;
        this.STEP_CONSTRAINT = stepConstraint;
    }
}
