package com.chess.game;

import com.chess.pieces.Piece;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private boolean white;
    private List<Piece> pieces;

    public Player(boolean white) {
        this.white = white;
        this.pieces = new ArrayList<>();
    }

}
