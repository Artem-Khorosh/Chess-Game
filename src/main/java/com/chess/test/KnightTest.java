package com.chess.test;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.Knight;
import com.chess.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KnightTest {
    @Test
    public void testKnightMoveLShape() {
        Board board = new Board();
        Square start = board.getSquare(1, 0);
        Square end = board.getSquare(2, 2);
        Piece knight = start.getPiece();

        assertTrue(knight.isValidMove(board, start, end));
    }

    @Test
    public void testKnightInvalidMove() {
        Board board = new Board();
        Square start = board.getSquare(1, 0);
        Square end = board.getSquare(3, 1);
        Piece knight = start.getPiece();

        assertFalse(knight.isValidMove(board, start, end));
    }
}