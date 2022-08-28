package com.chess;

import com.chess.pieces.Piece;
import com.chess.pieces.PieceColor;
import com.chess.pieces.PieceType;

public interface GameConstants {

        public static Piece NULL_PIECE = new Piece(null, PieceType.EXTRA, PieceColor.NONE);

        public static String ENTER_NAME = "Enter name for ";
        public static String COLON = ":";
        public static String PLAYER1 = "Player1";
        public static String PLAYER2 = "Player2";
        public static String SETTING_ENVIRONMENT = "Setting up environment....";
        public static String BOARD_READY = "Board is ready to play!";
        public static String ALIVE_PIECES = "Your remaining pieces are : ";
        public static String NEXT_MOVE_MESSAGE =
                        "Enter the number associated with above information to know the next possibe move for that piece, to quit enter -1: ";
        public static String POSSIBLE_MOVE = "Possible moves for %s from current location is/are: ";
        public static String PLAYERS_TURN = "%s's turn: ";
        public static String WANT_TO_MOVE =
                        "Do you want to move this piece. Enter Y for 'Yes' and N for 'No'.";
        public static String CORDINATE_OPTION =
                        "Enter cordinate option.(Option are listed beside cordinate)";
}
