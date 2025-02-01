package com.chess.test;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Rook;
import com.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    @Test
    public void testRookMoveHorizontal() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);

        for (int x = 1; x < 8; x++) {
            board.getSquare(x, 0).clear();
        }

        Square start = board.getSquare(0, 0);
        Square end = board.getSquare(7, 0);
        Piece rook = start.getPiece();

        assertTrue(rook.isValidMove(board, start, end));
    }

    @Test
    public void testRookMoveVertical() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);

        for (int y = 1; y < 8; y++) {
            board.getSquare(0, y).clear();
        }

        Square start = board.getSquare(0, 0);
        Square end = board.getSquare(0, 7);
        Piece rook = start.getPiece();

        assertTrue(rook.isValidMove(board, start, end));
    }
}
