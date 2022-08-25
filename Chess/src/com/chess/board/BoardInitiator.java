package com.chess.board;

import java.util.HashMap;
import java.util.Map;
import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.Piece;
import com.chess.pieces.PieceColor;
import com.chess.pieces.PieceFactory;
import com.chess.pieces.PieceType;

public class BoardInitiator {

    private PieceFactory pieceFactory;

    public BoardInitiator(PieceFactory pieceFactory) {
        this.pieceFactory = pieceFactory;
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

    public Piece[][] initiate(int rowCount, int colCount) {
        Piece[][] board = new Piece[rowCount + 1][colCount + 1];
        for (int i = 1; i <= colCount; i++) {
            board[2][i] = pieceFactory.createPiece(new MovableCoordinate(2, i), PieceType.PAWN,
                    PieceColor.WHITE);
            board[7][i] = pieceFactory.createPiece(new MovableCoordinate(7, i), PieceType.PAWN,
                    PieceColor.BLACK);
        }
        for (Map.Entry<Integer, PieceType> set : POSITIONS.entrySet()) {
            board[1][set.getKey()] = pieceFactory.createPiece(
                    new MovableCoordinate(1, set.getKey()), set.getValue(), PieceColor.WHITE);
            board[8][set.getKey()] = pieceFactory.createPiece(
                    new MovableCoordinate(8, set.getKey()), set.getValue(), PieceColor.BLACK);
        }
        return board;
    }
}
