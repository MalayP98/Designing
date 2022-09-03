package com.chess.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.chess.GameConstants;
import com.chess.coordinate.MovableCoordinate;
import com.chess.moves.MovingStrategyDistributor;
import com.chess.pieces.Piece;
import com.chess.pieces.PieceColor;
import com.chess.pieces.PieceFactory;

public class BoardState {

    private Board board;

    private BoardInitiator boardInitiator;

    private List<Piece> lostPieces = new ArrayList<>();

    private List<BoardStateObserver> observers = new ArrayList<>();

    private final String ANSI_RESET = "\u001B[0m";

    private final String ANSI_YELLOW = "\u001B[43m";

    private final String ANSI_BLUE = "\u001B[44m";

    public BoardState(Board board) {
        this.board = board;
        this.boardInitiator =
                new BoardInitiator(new PieceFactory(new MovingStrategyDistributor(this)), board);
        this.boardInitiator.initiate(Board.ROWS, Board.COLUMNS);
    }

    public boolean canMoveTo(MovableCoordinate to, MovableCoordinate from) {
        if (from.isValid() && to.isValid()) {
            if (getPieceAtCoordinate(to).equals(GameConstants.NULL_PIECE)) {
                return true;
            }
            return PieceColor.areOpposite(getPieceAtCoordinate(from).getPieceColor(),
                    getPieceAtCoordinate(to).getPieceColor());
        }
        return false;
    }

    public boolean isAttack(MovableCoordinate to, MovableCoordinate from) {
        if (from.isValid() && to.isValid()) {
            if (getPieceAtCoordinate(to).equals(GameConstants.NULL_PIECE)) {
                return false;
            }
            return PieceColor.areOpposite(getPieceAtCoordinate(from).getPieceColor(),
                    getPieceAtCoordinate(to).getPieceColor());
        }
        return false;
    }

    public Piece getPieceAtCoordinate(MovableCoordinate coordinate) {
        Piece piece = board.getPiece(coordinate);
        if (piece == null)
            return GameConstants.NULL_PIECE;
        return piece;
    }

    private void setPieceAtCoordinate(MovableCoordinate coordinate, Piece piece) {
        board.setPiece(coordinate, piece);
    }

    private Piece movePiece(MovableCoordinate to, MovableCoordinate from) {
        Piece targetPiece = getPieceAtCoordinate(from);
        if (Objects.nonNull(getPieceAtCoordinate(to))) {
            addLostPiece(getPieceAtCoordinate(to));
        }
        setPieceAtCoordinate(to, targetPiece);
        setPieceAtCoordinate(from, null);
        return targetPiece;
    }

    public void movePiece(MovableCoordinate to, MovableCoordinate from, PieceColor color) {
        if (color.equals(PieceColor.BLACK)) {
            to = to.reversePerspective();
            from = from.reversePerspective();
        }
        Piece targetPiece = movePiece(to, from);
        targetPiece.setCurrentCoordinate(
                color.equals(PieceColor.BLACK) ? to.reversePerspective() : to);
        notifyAllObservers();
    }

    public List<Piece> getAllPiecesWithColor(PieceColor color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 1; i <= Board.ROWS; i++) {
            for (int j = 1; j <= Board.COLUMNS; j++) {
                if (Objects.nonNull(board.getPiece(i, j))
                        && board.getPiece(i, j).getPieceColor().equals(color)) {
                    pieces.add(board.getPiece(i, j));
                }
            }
        }
        return pieces;
    }

    public List<Piece> getAllLostPiecesWithColor(PieceColor color) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece lostPiece : lostPieces) {
            if (lostPiece.getPieceColor().equals(color)) {
                pieces.add(lostPiece);
            }
        }
        return lostPieces;
    }

    private void addLostPiece(Piece piece) {
        lostPieces.add(piece);
    }

    public void subscribe(BoardStateObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (BoardStateObserver observer : observers) {
            observer.update();
        }
    }

    public void display() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null) {
                    String x = "";
                    x += piece.getPieceType().name().charAt(0);
                    x += piece.getPieceColor().name().charAt(0);
                    if (piece.isWhite())
                        System.out.print(ANSI_YELLOW + x + ANSI_RESET + " ");
                    else if (piece.isBlack())
                        System.out.print(ANSI_BLUE + x + ANSI_RESET + " ");
                } else
                    System.out.print("NN ");
            }
            System.out.println();
        }
    }
}
