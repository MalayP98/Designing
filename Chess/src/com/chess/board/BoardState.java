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

    public BoardState(Board board) {
        this.board = board;
        this.boardInitiator =
                new BoardInitiator(new PieceFactory(new MovingStrategyDistributor(this)));
        board.setBoard(this.boardInitiator.initiate(Board.ROWS, Board.COLUMNS));
    }

    public boolean canMoveTo(MovableCoordinate to, MovableCoordinate from) {
        if (getPieceAtCoordinate(to).equals(GameConstants.NULL_PIECE)) {
            return true;
        }
        return PieceColor.areOpposite(getPieceAtCoordinate(from).getPieceColor(),
                getPieceAtCoordinate(to).getPieceColor());
    }

    public boolean isAttack(MovableCoordinate to, PieceColor color) {
        if (color.equals(PieceColor.BLACK)) {
            to = to.reversePerspective();
        }
        return PieceColor.areOpposite(getPieceAtCoordinate(to).getPieceColor(), color);
    }

    public Piece getPieceAtCoordinate(MovableCoordinate coordinate) {
        Piece piece = board.getPiece(coordinate.getX().getValue(), coordinate.getY().getValue());
        if (piece == null)
            return GameConstants.NULL_PIECE;
        return piece;
    }

    private void setPieceAtCoordinate(MovableCoordinate coordinate, Piece piece) {
        board.setPiece(coordinate.getX().getValue(), coordinate.getY().getValue(), piece);
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
}
