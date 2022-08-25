package com.chess.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.chess.coordinate.MovableCoordinate;
import com.chess.models.Player;
import com.chess.moves.MovingStrategyFactory;
import com.chess.pieces.Piece;
import com.chess.pieces.PieceFactory;

public class BoardState {

    private Board board;

    private BoardInitiator boardInitiator;

    private List<Piece> lostPiecesForPlayerA = new ArrayList<>();

    private List<Piece> lostPiecesForPlayerB = new ArrayList<>();

    public BoardState(Board board) {
        this.board = board;
        this.boardInitiator = new BoardInitiator(new PieceFactory(new MovingStrategyFactory(this)));
        board.setBoard(this.boardInitiator.initiate(board.getRows(), board.getColumns()));
    }

    public boolean canMoveTo(MovableCoordinate to, MovableCoordinate from) {
        if (Objects.isNull(getPieceAtCoordinate(to))) {
            return true;
        }
        return !getPieceAtCoordinate(from).getPieceColor()
                .equals(getPieceAtCoordinate(to).getPieceColor());
    }

    public Piece getPieceAtCoordinate(MovableCoordinate coordinate) {
        return board.getBoard()[coordinate.getX().getValue()][coordinate.getY().getValue()];
    }

    public void setPieceAtCoordinate(MovableCoordinate coordinate, Piece piece) {
        board.getBoard()[coordinate.getX().getValue()][coordinate.getY().getValue()] = piece;
    }

    public void movePiece(MovableCoordinate to, MovableCoordinate from) {
        Piece targetPiece = getPieceAtCoordinate(from);
        targetPiece.setCurrentCoordinate(to);
        if (Objects.nonNull(getPieceAtCoordinate(to))) {
            // remove piece;
        }
        setPieceAtCoordinate(to, targetPiece);
        setPieceAtCoordinate(from, null);
    }

    public void addLostPiece(Player forPlayer, Piece piece) throws Exception {
        switch (forPlayer.getSign()) {
            case "A":
                lostPiecesForPlayerA.add(piece);
                break;
            case "B":
                lostPiecesForPlayerB.add(piece);
                break;
            default:
                throw new Exception("No such player found.");
        }
    }
}
