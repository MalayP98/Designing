package com.chess.moves.movingStrategies;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.AbstractMovingStrategy;

public class LeftMovingStrategy extends AbstractMovingStrategy {

    public LeftMovingStrategy(BoardState boardState, int stepConstraint) {
        super(boardState, stepConstraint);
    }

    @Override
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate nextCoordinate = null;
        for (int step = 1; step <= STEP_CONSTRAINT; step++) {
            nextCoordinate = (moves.isEmpty()) ? currentCoordinate.moveLeft()
                    : moves.get(step - 1).moveLeft();
            if (!nextCoordinate.isValid()
                    || !boardState.canMoveTo(nextCoordinate, currentCoordinate)) {
                break;
            }
        }
        return moves;
    }

}
