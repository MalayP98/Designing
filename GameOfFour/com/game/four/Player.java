package com.game.four;

public class Player {

    private Long id;

    private String name;

    private Piece piece;

    public Player(String name, Piece piece) {
        this.id = IdGenerator.generate();
        this.name = name;
        this.piece = piece;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return name;
    }
}
