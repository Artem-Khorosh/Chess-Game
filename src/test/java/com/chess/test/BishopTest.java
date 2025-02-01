package com.chess.test;
import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Player;
import com.chess.pieces.Pawn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    @Test
    public void testBishopMoveDiagonal() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);

        board.getSquare(3, 1).clear();

        Square start = board.getSquare(2, 0);
        Square end = board.getSquare(4, 2);

        assertTrue(start.getPiece().isValidMove(board, start, end));
    }

    @Test
    void testBishopBlockedMove() {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);
        Board board = new Board(whitePlayer, blackPlayer);

        board.getSquare(3, 1).setPiece(new Pawn(true));

        Square start = board.getSquare(2, 0);
        Square end = board.getSquare(4, 2);

        assertFalse(start.getPiece().isValidMove(board, start, end));
    }
}
