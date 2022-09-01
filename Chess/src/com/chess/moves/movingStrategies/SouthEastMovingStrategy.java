package com.chess.moves.movingStrategies;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.AbstractMovingStrategy;
import com.chess.pieces.PieceColor;

public class SouthEastMovingStrategy extends AbstractMovingStrategy {

    public SouthEastMovingStrategy(BoardState boardState, int stepConstraint) {
        super(boardState, stepConstraint);
    }

    @Override
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate,
            MovableCoordinate actualCoordinate) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate nextCoordinate = null;
        for (int step = 1; step <= STEP_CONSTRAINT; step++) {
            nextCoordinate = (moves.isEmpty()) ? currentCoordinate.moveSouthEast()
                    : moves.get(moves.size() - 1).moveSouthEast();
            if (isValidMove(actualCoordinate, nextCoordinate)) {
                moves.add(nextCoordinate);
            }
        }
        return moves;
    }
}
