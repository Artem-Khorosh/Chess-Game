package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public class King extends Piece {
    private boolean hasMoved = false;

    public King(boolean white) {
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

    // Проверка условий для рокировки
    public boolean canCastle(Board board, Square rookSquare) {
        // ... логика проверки ...
    }

    @Override
    public boolean isValidMove(Board board, Square start, Square end) {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        // King moves one square in any direction
        if (Math.abs(x2 - x1) <= 1 && Math.abs(y2 - y1) <= 1){
            return board.isPathClear(start, end);
        }
        return false;

    }
}