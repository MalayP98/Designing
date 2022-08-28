package com.chess.pieces;

public enum PieceColor {
    WHITE, BLACK, NONE;

    public static boolean areOpposite(PieceColor colorA, PieceColor colorB) {
        return ((colorA.equals(BLACK) && colorB.equals(WHITE))
                || (colorA.equals(WHITE) && colorB.equals(BLACK)));
    }
}
