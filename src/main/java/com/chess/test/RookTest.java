package com.chess.test;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.Rook;
import com.chess.pieces.Piece;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RookTest {
    @Test
    public void testRookMoveHorizontal() {
        Board board = new Board();
        Square start = board.getSquare(0, 0);
        Square end = board.getSquare(7, 0);
        Piece rook = start.getPiece();

        assertTrue(rook.isValidMove(board, start, end));
    }

    @Test
    public void testRookMoveVertical() {
        Board board = new Board();
        Square start = board.getSquare(0, 0);
        Square end = board.getSquare(0, 7);
        Piece rook = start.getPiece();

        assertTrue(rook.isValidMove(board, start, end));
    }
}
