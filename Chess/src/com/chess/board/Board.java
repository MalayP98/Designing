package com.chess.board;

import com.chess.pieces.Piece;

public class Board {

    private final int DEFAULT_ROWS = 8;

    private final int DEFAULT_COLUMNS = 8;

    public static int ROWS = -1;

    public static int COLUMNS = -1;

    private Piece[][] board;

    public Board() {
        Board.ROWS = DEFAULT_ROWS;
        Board.COLUMNS = DEFAULT_COLUMNS;
        this.board = new Piece[ROWS + 1][COLUMNS + 1];
    }

    public Board(int rows, int column) throws Exception {
        if (rows < DEFAULT_ROWS || COLUMNS < DEFAULT_COLUMNS) {
            throw new Exception("Invalid boards dimensions.");
        }
        Board.ROWS = rows;
        Board.COLUMNS = column;
        this.board = new Piece[rows + 1][COLUMNS + 1];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public Piece getPiece(int x, int y) {
        if (validRange(x) && validRange(y)) {
            return board[x][y];
        }
        return null;
    }

    public void setPiece(int x, int y, Piece piece) {
        if (validRange(x) && validRange(y)) {
            board[x][y] = piece;
        }
    }

    private boolean validRange(int x) {
        return (x > 0 && x < 9);
    }
}
