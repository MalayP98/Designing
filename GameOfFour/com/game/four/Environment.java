package com.game.four;

import com.game.four.judges.HorizontalJudge;
import com.game.four.judges.NorthEastJudge;
import com.game.four.judges.SouthEastJudge;
import com.game.four.judges.VerticalJudge;

public class Environment {

    public void run() {
        Board board = new Board(6, 7);
        Game game = new Game(board, 2);
        Player player1 = new Player("Player1", Piece.RED);
        Player player2 = new Player("Player2", Piece.YELLOW);
        game.addPlayer(player1);
        game.addPlayer(player2);
        HorizontalJudge horizontalJudge = new HorizontalJudge(board);
        VerticalJudge verticalJudge = new VerticalJudge(board);
        NorthEastJudge northEastJudge = new NorthEastJudge(board);
        SouthEastJudge southEastJudge = new SouthEastJudge(board);
        game.subscribe(northEastJudge);
        game.subscribe(southEastJudge);
        game.subscribe(horizontalJudge);
        game.subscribe(verticalJudge);
        game.start();
    }
}
