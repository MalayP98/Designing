package com.chess.board;

import com.chess.models.Player;
import com.chess.pieces.Piece;

public class Board {

    private Player playerA;

    private Player playerB;

    private final int ROWS = 8;

    private final int COLUMNS = 8;

    private Piece[][] board;

    public Board(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.board = new Piece[ROWS][COLUMNS];
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
}
