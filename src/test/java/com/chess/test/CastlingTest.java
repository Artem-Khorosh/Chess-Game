package com.chess.test;


import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.King;
import com.chess.pieces.Rook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CastlingTest {
    @Test
    void testKingsideCastling() {
        Player white = new Player(true);
        Board board = new Board(white, new Player(false));

        Square kingStart = board.getSquare(4, 0);
        Square rookStart = board.getSquare(7, 0);

        // Убираем фигуры между королём и ладьёй
        board.getSquare(5, 0).clear();
        board.getSquare(6, 0).clear();

        King king = (King) kingStart.getPiece();
        Rook rook = (Rook) rookStart.getPiece();

        assertTrue(king.canCastle(board, rookStart));
    }
}
