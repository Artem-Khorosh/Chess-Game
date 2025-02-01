package com.chess.test;


import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Pawn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testClearPathHorizontal() {
        Player white = new Player(true);
        Player black = new Player(false);
        Board board = new Board(white, black);

        for (int x = 1; x < 8; x++) {
            board.getSquare(x, 0).clear();
        }

        Square start = board.getSquare(0, 0); // Ладья
        Square end = board.getSquare(7, 0);   // Горизонталь

        assertTrue(board.isPathClear(start, end));
    }

    @Test
    void testBlockedPathDiagonal() {
        Player white = new Player(true);
        Player black = new Player(false);
        Board board = new Board(white, black);

        Square start = board.getSquare(2, 0); // Слон
        board.getSquare(3, 1).setPiece(new Pawn(true)); // Препятствие
        Square end = board.getSquare(4, 2);

        assertFalse(board.isPathClear(start, end));
    }
}