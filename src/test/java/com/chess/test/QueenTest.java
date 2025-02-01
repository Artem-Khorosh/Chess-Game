package com.chess.test;
import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Pawn;
import com.chess.pieces.Queen;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
    @Test
    void testQueenHorizontalMove() {
        Player white = new Player(true);
        Player black = new Player(false);
        Board board = new Board(white, black);

        Square start = board.getSquare(3, 0);
        start.clear();
        start.setPiece(new Queen(true));

        board.getSquare(4, 0).clear();
        board.getSquare(5, 0).clear();

        Square end = board.getSquare(5, 0);
        assertTrue(start.getPiece().isValidMove(board, start, end));
    }

    @Test
    void testQueenDiagonalBlocked() {
        Player white = new Player(true);
        Player black = new Player(false);
        Board board = new Board(white, black);

        Square start = board.getSquare(3, 0);
        board.getSquare(4, 1).setPiece(new Pawn(true));

        Square end = board.getSquare(5, 2);
        assertFalse(start.getPiece().isValidMove(board, start, end));
    }
}
