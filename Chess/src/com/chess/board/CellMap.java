package com.chess.board;

import java.util.HashMap;
import javax.swing.text.html.HTML.Tag;
import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.Piece;

public class CellMap extends HashMap<Integer, Piece> {

    public Piece put(MovableCoordinate coordinate, Piece piece) {
        return put(coordinate.toInteger(), piece);
    }

    // from will always be actual cordinate, to will be figured out with the help of from.
    public boolean canMove(MovableCoordinate from, MovableCoordinate to) {
        Piece targetPiece = get(from);
        if (targetPiece.isBlack()) {
            to = to.reversePerspective();
        }
        return !targetPiece.sameFamily(get(to));
    }

    public boolean isAttack(MovableCoordinate from, MovableCoordinate to) {
        return !canMove(from, to);
    }

    public Piece get(MovableCoordinate coordinate) {
        return get(coordinate.toInteger());
    }
}
