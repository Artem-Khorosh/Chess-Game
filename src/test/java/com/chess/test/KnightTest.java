package com.chess.test;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Knight;
import com.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class KnightTest {
    @Test
    public void testKnightMoveLShape() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);
        Square start = board.getSquare(1, 0);
        Square end = board.getSquare(2, 2);
        Piece knight = start.getPiece();

        assertTrue(knight.isValidMove(board, start, end));
    }

    @Test
    public void testKnightInvalidMove() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);
        Square start = board.getSquare(1, 0);
        Square end = board.getSquare(3, 1);
        Piece knight = start.getPiece();

        assertFalse(knight.isValidMove(board, start, end));
    }
}