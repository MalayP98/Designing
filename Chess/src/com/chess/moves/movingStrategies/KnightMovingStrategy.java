package com.chess.moves.movingStrategies;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.AbstractMovingStrategy;

public class KnightMovingStrategy extends AbstractMovingStrategy {

    public KnightMovingStrategy(BoardState boardState, int stepConstraint) {
        super(boardState, stepConstraint);
    }

    @Override
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate nextCoordinate = null;
        MovableCoordinate intermidiate = currentCoordinate.moveForward().moveForward();

        nextCoordinate = intermidiate.moveRight();
        addIfValid(moves, nextCoordinate, currentCoordinate);
        nextCoordinate = intermidiate.moveLeft();
        addIfValid(moves, nextCoordinate, currentCoordinate);

        intermidiate = currentCoordinate.moveBackward().moveBackward();
        nextCoordinate = intermidiate.moveRight();
        addIfValid(moves, nextCoordinate, currentCoordinate);
        nextCoordinate = intermidiate.moveLeft();
        addIfValid(moves, nextCoordinate, currentCoordinate);

        intermidiate = currentCoordinate.moveLeft().moveLeft();
        nextCoordinate = intermidiate.moveForward();
        addIfValid(moves, nextCoordinate, currentCoordinate);
        nextCoordinate = intermidiate.moveBackward();
        addIfValid(moves, nextCoordinate, currentCoordinate);

        intermidiate = currentCoordinate.moveRight().moveRight();
        nextCoordinate = intermidiate.moveForward();
        addIfValid(moves, nextCoordinate, currentCoordinate);
        nextCoordinate = intermidiate.moveBackward();
        addIfValid(moves, nextCoordinate, currentCoordinate);

        return moves;
    }

    private void addIfValid(List<MovableCoordinate> moves, MovableCoordinate to,
            MovableCoordinate from) {
        if (to.isValid() || boardState.canMoveTo(to, from))
            moves.add(to);
    }
}
