package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        int direction = isWhite() ? 1 : -1;

        // Move forward one square
        if (x1 == x2 && y2 == y1 + direction && end.isEmpty()) {
            return true;
        }

        // Move forward two squares (only from starting position)
        if (x1 == x2 && y2 == y1 + 2 * direction && (y1 == 1 || y1 == 6) && end.isEmpty()) {
            return board.isPathClear(start, end);
        }

        // Capture diagonally
    if (Math.abs(x2 - x1) == 1 && y2 == y1 + direction && !end.isEmpty()
            && end.getPiece().isWhite() != isWhite()) {
            return true;
    }

        return false;
    }

}
