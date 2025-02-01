package com.chess.test;


import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.game.Game;
import com.chess.game.Player;
import com.chess.pieces.King;
import com.chess.pieces.Rook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    @Test
    void testKingNormalMove() {
        Game game = new Game();
        Board board = game.getBoard();
        Player white = game.getWhitePlayer();

        Square start = board.getSquare(4, 0);
        Square end = board.getSquare(5, 1);

        assertTrue(start.getPiece().isValidMove(board, start, end));
    }

    @Test
    void testKingInCheck() {
        Player white = new Player(true);
        Player black = new Player(false);
        Board board = new Board(white, black);

        board.getSquare(4, 1).clear();
        board.getSquare(4, 6).clear();

        Rook blackRook = new Rook(false);
        Square targetSquare = board.getSquare(4, 7);
        targetSquare.setPiece(blackRook);
        black.getPieces().add(blackRook);


        assertTrue(board.isInCheck(white));
    }
}