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
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate,
            MovableCoordinate actualCoordinate) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate nextCoordinate = null;
        MovableCoordinate intermidiate = currentCoordinate.moveForward().moveForward();

        nextCoordinate = intermidiate.moveRight();
        addIfValid(moves, nextCoordinate, actualCoordinate);
        nextCoordinate = intermidiate.moveLeft();
        addIfValid(moves, nextCoordinate, actualCoordinate);

        intermidiate = currentCoordinate.moveBackward().moveBackward();
        nextCoordinate = intermidiate.moveRight();
        addIfValid(moves, nextCoordinate, actualCoordinate);
        nextCoordinate = intermidiate.moveLeft();
        addIfValid(moves, nextCoordinate, actualCoordinate);

        intermidiate = currentCoordinate.moveLeft().moveLeft();
        nextCoordinate = intermidiate.moveForward();
        addIfValid(moves, nextCoordinate, actualCoordinate);
        nextCoordinate = intermidiate.moveBackward();
        addIfValid(moves, nextCoordinate, actualCoordinate);

        intermidiate = currentCoordinate.moveRight().moveRight();
        nextCoordinate = intermidiate.moveForward();
        addIfValid(moves, nextCoordinate, actualCoordinate);
        nextCoordinate = intermidiate.moveBackward();
        addIfValid(moves, nextCoordinate, actualCoordinate);

        return moves;
    }

    private void addIfValid(List<MovableCoordinate> moves, MovableCoordinate to,
            MovableCoordinate from) {
        if (isValidMove(from, to)) {
            moves.add(to);
        }
    }
}
