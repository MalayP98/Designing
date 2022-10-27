package com.game.four.judges;

import com.game.four.Board;
import com.game.four.Cordinate;
import com.game.four.Piece;

public class NorthEastJudge extends Observer {

    public NorthEastJudge(Board board) {
        super(board);
    }

    @Override
    public boolean notify_(Cordinate cordinate) {
        Integer[] dimensions = board.getDimensions();
        int row = dimensions[0];
        int column = dimensions[1];
        int similarDiscCount = 0;
        Piece previousPiece = Piece.NONE;
        // some logic
        return false;
    }
}
