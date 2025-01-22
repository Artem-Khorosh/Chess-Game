package com.chess.board;

import com.chess.pieces.Piece;
import lombok.Data;

@Data
public class Square {
    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void clear() {
        this.piece = null;
    }
}
