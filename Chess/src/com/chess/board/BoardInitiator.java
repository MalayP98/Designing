package com.chess.board;

import java.util.HashMap;
import java.util.Map;
import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.PieceColor;
import com.chess.pieces.PieceFactory;
import com.chess.pieces.PieceType;

public class BoardInitiator {

    private PieceFactory pieceFactory;

    private Board board;

    public BoardInitiator(PieceFactory pieceFactory, Board board) {
        this.pieceFactory = pieceFactory;
        this.board = board;
    }

    private final Map<Integer, PieceType> POSITIONS = new HashMap<>() {
        {
            put(1, PieceType.ROOK);
            put(2, PieceType.BISHOP);
            put(3, PieceType.KNIGHT);
            put(4, PieceType.QUEEN);
            put(5, PieceType.KING);
            put(6, PieceType.KNIGHT);
            put(7, PieceType.BISHOP);
            put(8, PieceType.ROOK);
        }
    };

    public void initiate(int rowCount, int colCount) {
        for (int i = 1; i <= 8; i++) {
            MovableCoordinate position = new MovableCoordinate(2, i);
            board.setPiece(position,
                    pieceFactory.createPiece(position, PieceType.PAWN, PieceColor.WHITE));
            board.setPiece(position.reversePerspective(),
                    pieceFactory.createPiece(position, PieceType.PAWN, PieceColor.BLACK));
        }
        for (Map.Entry<Integer, PieceType> set : POSITIONS.entrySet()) {
            MovableCoordinate position = new MovableCoordinate(1, set.getKey());
            board.setPiece(position,
                    pieceFactory.createPiece(position, set.getValue(), PieceColor.WHITE));
            board.setPiece(position.reversePerspective(),
                    pieceFactory.createPiece(position, set.getValue(), PieceColor.BLACK));
        }
    }
}
