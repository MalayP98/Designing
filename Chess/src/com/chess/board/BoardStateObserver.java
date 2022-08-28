package com.chess.board;

public abstract class BoardStateObserver {

    protected BoardState boardState;

    public BoardStateObserver(BoardState boardState) {
        this.boardState = boardState;
        boardState.subscribe(this);
    }

    public abstract void update();
}
