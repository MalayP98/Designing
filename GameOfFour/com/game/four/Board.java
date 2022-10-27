package com.game.four;

public class Board {

    private int row;

    private int column;

    private Piece[][] board;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Piece[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = Piece.NONE;
            }
        }
    }

    public Piece get(int x, int y) {
        return board[x][y];
    }

    public void set(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public Piece get(Cordinate cordinate) {
        return board[cordinate.getX()][cordinate.getY()];
    }

    public void set(Cordinate cordinate, Piece piece) {
        board[cordinate.getX()][cordinate.getY()] = piece;
    }

    public Integer[] getDimensions() {
        Integer[] dimensions = new Integer[2];
        dimensions[0] = row;
        dimensions[1] = column;
        return dimensions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                switch (get(i, j)) {
                    case NONE:
                        builder.append("N ");
                        break;
                    case RED:
                        builder.append("R ");
                        break;
                    case YELLOW:
                        builder.append("Y ");
                        break;
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
