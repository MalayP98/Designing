package com.chess.models;

import com.chess.pieces.PieceColor;

public class Player {

    private String name;

    private PieceColor color;

    private String sign;

    public Player(String name, String sign, PieceColor color) {
        this.name = name;
        this.sign = sign;
        this.color = color;
    }

    public String getSign() {
        return sign;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }
}
