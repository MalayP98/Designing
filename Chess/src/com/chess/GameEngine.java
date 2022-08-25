package com.chess;

import java.util.Random;
import java.util.Scanner;
import com.chess.board.Board;
import com.chess.board.BoardState;
import com.chess.models.Player;
import com.chess.pieces.PieceColor;

public class GameEngine {

    private final Random RANDOM = new Random();

    private final Scanner SCANNER = new Scanner(System.in);

    public void start() {

        Player[] players = generatePlayers();
        System.out.println(GameConstants.SETTING_ENVIRONMENT);
        Board chessBoard = new Board(players[0], players[1]);
        BoardState boardState = new BoardState(chessBoard);
        System.out.println(GameConstants.BOARD_READY);
    }

    private PieceColor getPieceColor() {
        return (RANDOM.nextInt(7) % 2 == 0) ? PieceColor.BLACK : PieceColor.WHITE;
    }

    private PieceColor getOppositePieceColor(PieceColor color) {
        return (color.equals(PieceColor.BLACK)) ? PieceColor.WHITE : PieceColor.BLACK;
    }

    private Player[] generatePlayers() {
        String name = "";

        System.out.println(GameConstants.ENTER_NAME + GameConstants.PLAYER1 + GameConstants.COLON);
        name = SCANNER.nextLine();
        Player playerA = new Player(name, "A", getPieceColor());

        System.out.println(GameConstants.ENTER_NAME + GameConstants.PLAYER2 + GameConstants.COLON);
        name = SCANNER.nextLine();
        Player playerB = new Player(name, "B", getOppositePieceColor(playerA.getColor()));

        Player[] players = new Player[2];
        players[0] = playerA;
        players[1] = playerB;

        return players;
    }
}
