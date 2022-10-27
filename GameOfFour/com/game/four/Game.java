package com.game.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.game.four.judges.Observer;

public class Game {

    private int maxPalyers;

    private Board board;

    private List<Player> players = new ArrayList();

    private List<Observer> judges = new ArrayList<>();

    private final Scanner SCANNER = new Scanner(System.in);

    public Game(Board board, int maxPalyers) {
        this.maxPalyers = maxPalyers;
        this.board = board;
    }

    public void addPlayer(Player player) {
        if (players.size() == maxPalyers) {
            System.out.println("Max palyer limit reached. Cannot add more player.");
            return;
        }
        players.add(player);
    }

    public void start() {
        while (true) {
            for (Player player : players) {
                System.out.println(player + ", your move. \n");
                if (move(player.getPiece())) {
                    System.out.println("Congratulation " + player + ", you won!");
                    return;
                }
            }
        }
    }

    private boolean move(Piece piece) {
        displayBoard();
        List<Cordinate> lastEmptyCells = getLastEmptyCells();
        for (int i = 1; i <= lastEmptyCells.size(); i++) {
            System.out.println(i + ": " + lastEmptyCells.get(i - 1));
        }
        int move = SCANNER.nextInt();
        if (move < 1 || move > lastEmptyCells.size()) {
            System.out.println("Invalid move. Try again!");
            return move(piece);
        }
        Cordinate cordinate = lastEmptyCells.get(move - 1);
        board.set(cordinate, piece);
        return notifyAll_(cordinate);
    }

    public List<Cordinate> getLastEmptyCells() {
        Integer[] dimensions = board.getDimensions();
        int row = dimensions[0];
        int column = dimensions[1];
        List<Cordinate> lastEmptyCells = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (board.get(j, i).equals(Piece.NONE)
                        && (j + 1 >= row || board.get(j + 1, i).equals(Piece.RED)
                                || board.get(j + 1, i).equals(Piece.YELLOW))) {
                    lastEmptyCells.add(new Cordinate(j, i));
                    break;
                }
            }
        }
        return lastEmptyCells;
    }

    private void displayBoard() {
        System.out.println("********* Current Board Status *********\n");
        System.out.println(board);
        System.out.println("****************************************\n");
    }

    public void subscribe(Observer judge) {
        judges.add(judge);
    }

    public boolean notifyAll_(Cordinate cordinate) {
        for (Observer judge : judges) {
            if (judge.notify_(cordinate))
                return true;
        }
        return false;
    }
}
