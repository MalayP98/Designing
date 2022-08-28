package com.chess.moves;

import java.util.List;
import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.PieceColor;

public interface MovingStrategy {

    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate,
            PieceColor forColor);

}
