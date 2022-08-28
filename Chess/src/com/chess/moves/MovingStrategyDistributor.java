package com.chess.moves;

import java.util.ArrayList;
import java.util.List;
import com.chess.board.BoardState;
import com.chess.moves.movingStrategies.BackwardMovingStrategy;
import com.chess.moves.movingStrategies.ForwardMovingStrategy;
import com.chess.moves.movingStrategies.KnightMovingStrategy;
import com.chess.moves.movingStrategies.LeftMovingStrategy;
import com.chess.moves.movingStrategies.NorthEastMovingStrategy;
import com.chess.moves.movingStrategies.NorthWestMovingStrategy;
import com.chess.moves.movingStrategies.PawnAttackingStrategy;
import com.chess.moves.movingStrategies.RightMovingStrategy;
import com.chess.moves.movingStrategies.SouthEastMovingStrategy;
import com.chess.moves.movingStrategies.SouthWestMovingStrategy;
import com.chess.pieces.PieceType;

public class MovingStrategyDistributor {

    private BoardState boardState;

    public MovingStrategyDistributor(BoardState boardState) {
        this.boardState = boardState;
    }

    public List<MovingStrategy> getMovingStrategyFor(PieceType type) {
        List<MovingStrategy> strategies = new ArrayList<>();
        switch (type) {
            case BISHOP:
                strategies.add(new NorthEastMovingStrategy(boardState, 8));
                strategies.add(new NorthWestMovingStrategy(boardState, 8));
                strategies.add(new SouthEastMovingStrategy(boardState, 8));
                strategies.add(new SouthWestMovingStrategy(boardState, 8));
                break;
            case KING:
                strategies.add(new NorthEastMovingStrategy(boardState, 1));
                strategies.add(new NorthWestMovingStrategy(boardState, 1));
                strategies.add(new SouthEastMovingStrategy(boardState, 1));
                strategies.add(new SouthWestMovingStrategy(boardState, 1));
                strategies.add(new ForwardMovingStrategy(boardState, 1));
                strategies.add(new BackwardMovingStrategy(boardState, 1));
                strategies.add(new LeftMovingStrategy(boardState, 1));
                strategies.add(new RightMovingStrategy(boardState, 1));
                break;
            case KNIGHT:
                strategies.add(new KnightMovingStrategy(boardState, 8));
                break;
            case PAWN:
                strategies.add(new ForwardMovingStrategy(boardState, 1));
                strategies.add(new PawnAttackingStrategy(boardState, 1));
                break;
            case QUEEN:
                strategies.addAll(getMovingStrategyFor(PieceType.ROOK));
                strategies.addAll(getMovingStrategyFor(PieceType.BISHOP));
                break;
            case ROOK:
                strategies.add(new ForwardMovingStrategy(boardState, 8));
                strategies.add(new BackwardMovingStrategy(boardState, 8));
                strategies.add(new LeftMovingStrategy(boardState, 8));
                strategies.add(new RightMovingStrategy(boardState, 8));
                break;
            default:
                break;
        }
        return strategies;
    }
}
