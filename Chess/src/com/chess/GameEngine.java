package com.chess;

import java.security.Policy;
import java.util.Random;
import java.util.Scanner;
import com.chess.board.Board;
import com.chess.board.BoardState;
import com.chess.coordinate.MovableCoordinate;
import com.chess.models.Player;
import com.chess.pieces.Piece;
import com.chess.pieces.PieceColor;

public class GameEngine {

    private final Random RANDOM = new Random();

    private final Scanner SCANNER = new Scanner(System.in);

    private BoardState boardState;

    public void start() throws Exception {

        System.out.println(GameConstants.SETTING_ENVIRONMENT);
        Board chessBoard = new Board();
        boardState = new BoardState(chessBoard);
        System.out.println(GameConstants.BOARD_READY);
        Player[] players = generatePlayers(boardState);
        start(players[0], players[1], true);
    }

    private void start(Player A, Player B, boolean turn) throws Exception {
        while (true) {
            if (turn) {
                move(A);
            } else {
                move(B);
            }
            turn = !turn;
        }
    }

    private void move(Player player) throws Exception {
        System.out.println(String.format(GameConstants.PLAYERS_TURN, player.getName()));
        System.out.println(GameConstants.ALIVE_PIECES);
        int choice = 1;
        for (Piece piece : player.alivePieces()) {
            System.out.println(choice + ": " + piece.toString());
            choice++;
        }
        char wantToMove = 'N';
        do {
            choice = SCANNER.nextInt();
            if (choice == -1)
                break;
            else if (choice > player.alivePieces().size()) {
                System.out.println("Invalid choice.");
                continue;
            } else {
                showAvaialableMoves(player.alivePieces().get(choice - 1));
                System.out.println(GameConstants.WANT_TO_MOVE);
                wantToMove = SCANNER.next().charAt(0);
                if (wantToMove == 'N') {
                    continue;
                } else if (wantToMove == 'Y') {
                    movePiece(player, choice);
                    return;
                } else
                    throw new Exception("No a valid input.");
            }
        } while (wantToMove != 'Y');
    }

    private void showAvaialableMoves(Piece piece) {
        System.out.println(String.format(GameConstants.POSSIBLE_MOVE, piece.pieceName()));
        int option = 1;
        System.out.print("[");
        for (MovableCoordinate coordinate : piece.getMoves()) {
            System.out.print(option + ": " + coordinate.toString()
                    + ((option < piece.getMoves().size()) ? " " : ""));
            option++;
        }
        System.out.println("]");
    }

    private void movePiece(Player player, int choice) throws Exception {
        System.out.println(GameConstants.CORDINATE_OPTION);
        int option = SCANNER.nextInt();
        if (option < 1 || option > player.alivePieces().get(choice - 1).getMoves().size()) {
            throw new Exception("No such move available.");
        } else {
            boardState.movePiece(player.alivePieces().get(choice - 1).getMoves().get(option - 1),
                    player.alivePieces().get(choice - 1).getCoordinate(), player.getColor());
        }
    }

    private PieceColor decidePieceColor() {
        return (RANDOM.nextInt(7) % 2 == 0) ? PieceColor.BLACK : PieceColor.WHITE;
    }

    private PieceColor decideOppositePieceColor(PieceColor color) {
        return (color.equals(PieceColor.BLACK)) ? PieceColor.WHITE : PieceColor.BLACK;
    }

    private Player[] generatePlayers(BoardState boardState) {
        String name = "";

        System.out.println(GameConstants.ENTER_NAME + GameConstants.PLAYER1 + GameConstants.COLON);
        name = SCANNER.nextLine();
        Player playerA = new Player(name, "A", decidePieceColor(), boardState);

        System.out.println(GameConstants.ENTER_NAME + GameConstants.PLAYER2 + GameConstants.COLON);
        name = SCANNER.nextLine();
        Player playerB =
                new Player(name, "B", decideOppositePieceColor(playerA.getColor()), boardState);

        Player[] players = new Player[2];
        players[0] = playerA;
        players[1] = playerB;

        return players;
    }
}
