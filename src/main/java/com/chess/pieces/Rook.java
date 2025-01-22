package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public class Rook extends Piece {
    private boolean hasMoved = false;

    public Rook(boolean white) {
        super(white);
    }
    public boolean hasMoved() {
        return hasMoved;
    }
    @Override
    public void move(Board board, Square start, Square end) {
        super.move(board, start, end);
        hasMoved = true;
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        // The rook can move horizontally or vertically
        if (x1 == x2 || y1 == y2) {
            return board.isPathClear(start, end);
        }
        return false;
    }
}
