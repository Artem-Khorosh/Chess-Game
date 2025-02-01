package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        if (start == null || end == null) {
            return false;
        }
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        // Queen moves like a rook or bishop
        if ((x1 == x2 || y1 == y2) || (Math.abs(x2 - x1) == Math.abs(y2 - y1))){
            return board.isPathClear(start, end);
        }
        return false;

    }
}