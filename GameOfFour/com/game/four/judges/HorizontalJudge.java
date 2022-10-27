package com.game.four.judges;

import com.game.four.Board;
import com.game.four.Cordinate;
import com.game.four.Piece;

public class HorizontalJudge extends Observer {

    public HorizontalJudge(Board board) {
        super(board);
    }

    @Override
    public boolean notify_(Cordinate cordinate) {
        Integer[] dimensions = board.getDimensions();
        int column = dimensions[1];
        int similarDiscCount = 0;
        Piece previousPiece = Piece.NONE;
        for (int i = 0; i < column; i++) {
            Piece currentPiece = board.get(cordinate.getX(), i);
            if (Piece.NONE.equals(currentPiece)) {
                similarDiscCount = 0;
            } else if (Piece.NONE.equals(previousPiece)) {
                similarDiscCount = 1;
                previousPiece = currentPiece;
            } else if (currentPiece.equals(previousPiece)) {
                similarDiscCount++;
            } else {
                similarDiscCount = 0;
                previousPiece = currentPiece;
            }
            if (similarDiscCount == 4)
                return true;
        }
        return false;
    }
}
