package com.game.four.judges;

import com.game.four.Board;
import com.game.four.Cordinate;

public abstract class Observer {

    protected Board board;

    public Observer(Board board) {
        this.board = board;
    }

    public abstract boolean notify_(Cordinate cordinate);
}
