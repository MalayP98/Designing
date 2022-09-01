package com.chess.moves;

import java.util.List;
import com.chess.coordinate.MovableCoordinate;

public interface MovingStrategy {

    public List<MovableCoordinate> getMoves(MovableCoordinate currentCoordinate,
            MovableCoordinate actualCoordinate);

}
