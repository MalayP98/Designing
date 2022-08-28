package com.chess.models;

import java.util.List;
import com.chess.board.BoardState;
import com.chess.board.BoardStateObserver;
import com.chess.pieces.Piece;
import com.chess.pieces.PieceColor;

public class Player extends BoardStateObserver {

    private String name;

    private PieceColor color;

    private String sign;

    private List<Piece> alivePieces;

    public Player(String name, String sign, PieceColor color, BoardState boardState) {
        super(boardState);
        this.name = name;
        this.sign = sign;
        this.color = color;
        update();
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

    public List<Piece> alivePieces() {
        return alivePieces;
    }

    @Override
    public void update() {
        this.alivePieces = boardState.getAllPiecesWithColor(color);
    }
}
