package com.chess.board;

import com.chess.coordinate.MovableCoordinate;
import com.chess.pieces.Piece;

public class Board {

    private final int DEFAULT_ROWS = 8;

    private final int DEFAULT_COLUMNS = 8;

    public static int ROWS = -1;

    public static int COLUMNS = -1;

    private CellMap board;

    public Board() {
        Board.ROWS = DEFAULT_ROWS;
        Board.COLUMNS = DEFAULT_COLUMNS;
        this.board = new CellMap();
    }

    public Board(int rows, int column) throws Exception {
        if (rows < DEFAULT_ROWS || COLUMNS < DEFAULT_COLUMNS) {
            throw new Exception("Invalid boards dimensions.");
        }
        Board.ROWS = rows;
        Board.COLUMNS = column;
        this.board = new CellMap();
    }

    public Piece getPiece(MovableCoordinate coordinate) {

        if (validRange(coordinate.getX().getValue()) && validRange(coordinate.getY().getValue())) {
            return board.get(coordinate);
        }
        return null;
    }

    public Piece getPiece(int x, int y) {
        return getPiece(new MovableCoordinate(x, y));
    }

    public void setPiece(MovableCoordinate coordinate, Piece piece) {
        if (validRange(coordinate.getX().getValue()) && validRange(coordinate.getY().getValue())) {
            board.put(coordinate, piece);
        }
    }

    private boolean validRange(int x) {
        return (x > 0 && x < 9);
    }
}
