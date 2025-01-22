package com.chess.test;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PawnTest {
    @Test
    public void testPawnMoveForward() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);
        Square start = board.getSquare(0, 1);
        Square end = board.getSquare(0, 2);
        Piece pawn = start.getPiece();

        assertTrue(pawn.isValidMove(board, start, end));
        pawn.move(board, start, end);
        assertNull(start.getPiece());
        assertEquals(pawn, end.getPiece());
    }

    @Test
    public void testPawnInvalidMove() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);
        Square start = board.getSquare(0, 1);
        Square end = board.getSquare(1, 2);
        Piece pawn = start.getPiece();

        assertFalse(pawn.isValidMove(board, start, end));
    }
    @Test
    void testPawnCapture() {
        Board board = new Board(new Player(true), new Player(false));
        Square start = board.getSquare(0, 1);
        Square end = board.getSquare(1, 2);
        board.getSquare(1, 2).setPiece(new Pawn(false));

        assertTrue(start.getPiece().isValidMove(board, start, end));
    }
}