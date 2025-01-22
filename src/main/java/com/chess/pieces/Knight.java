package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        // Knight moves in an L-shape
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)){
            return end.isEmpty() || end.getPiece().isWhite() != isWhite();
        }
        return false;
    }
}
