package com.chess.pieces;

import com.chess.board.Board;
import com.chess.board.Square;

public interface Moveable {
    boolean isValidMove(Board board, Square start, Square end);
}
