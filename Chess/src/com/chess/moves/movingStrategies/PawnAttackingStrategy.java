package com.chess.moves.movingStrategies;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.AbstractMovingStrategy;

public class PawnAttackingStrategy extends AbstractMovingStrategy {

    public PawnAttackingStrategy(BoardState boardState, int stepConstraint) {
        super(boardState, stepConstraint);
    }

    @Override
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate,
            MovableCoordinate actualCoordinate) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate leftDiagonal = currentCoordinate.moveNorthWest();
        MovableCoordinate rightDiagonal = currentCoordinate.moveNorthEast();
        if (boardState.getPieceAtCoordinate(actualCoordinate).isBlack()) {
            leftDiagonal = leftDiagonal.reversePerspective();
            rightDiagonal = rightDiagonal.reversePerspective();
        }
        if (boardState.isAttack(leftDiagonal, actualCoordinate)) {
            moves.add((boardState.getPieceAtCoordinate(actualCoordinate).isBlack())
                    ? leftDiagonal.reversePerspective()
                    : leftDiagonal);
        }
        if (boardState.isAttack(rightDiagonal, actualCoordinate)) {
            moves.add((boardState.getPieceAtCoordinate(actualCoordinate).isBlack())
                    ? rightDiagonal.reversePerspective()
                    : rightDiagonal);
        }
        return moves;
    }
}
