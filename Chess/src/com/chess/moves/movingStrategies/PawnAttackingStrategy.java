package com.chess.moves.movingStrategies;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.AbstractMovingStrategy;
import com.chess.pieces.PieceColor;

public class PawnAttackingStrategy extends AbstractMovingStrategy {

    public PawnAttackingStrategy(BoardState boardState, int stepConstraint) {
        super(boardState, stepConstraint);
    }

    @Override
    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate, PieceColor color) {
        List<MovableCoordinate> moves = new ArrayList<>();
        MovableCoordinate leftDiagonal = currentCoordinate.moveNorthWest();
        MovableCoordinate rightDiagonal = currentCoordinate.moveNorthEast();
        if (color.equals(PieceColor.BLACK)) {
            if (leftDiagonal.isValid() && PieceColor.areOpposite(boardState
                    .getPieceAtCoordinate(leftDiagonal.reversePerspective()).getPieceColor(),
                    color)) {
                moves.add(leftDiagonal);
            }
            if (rightDiagonal.isValid() && PieceColor.areOpposite(boardState
                    .getPieceAtCoordinate(rightDiagonal.reversePerspective()).getPieceColor(),
                    color)) {
                moves.add(rightDiagonal);
            }
        } else {
            if (leftDiagonal.isValid() && PieceColor.areOpposite(
                    boardState.getPieceAtCoordinate(leftDiagonal).getPieceColor(), color)) {
                moves.add(leftDiagonal);
            }
            if (rightDiagonal.isValid() && PieceColor.areOpposite(
                    boardState.getPieceAtCoordinate(rightDiagonal).getPieceColor(), color)) {
                moves.add(rightDiagonal);
            }
        }
        return moves;
    }
}
