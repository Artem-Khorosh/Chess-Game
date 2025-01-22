package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;


public abstract class Piece implements Moveable {
    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void move(Board board, Square start, Square end) {
        if (isValidMove(board, start, end)) {
            Piece capturedPiece = end.getPiece();
            if (capturedPiece != null) {
                board.removePiece(capturedPiece);
            }
            end.setPiece(this);
            start.clear();
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }
}
