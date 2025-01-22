package com.chess.board;

import com.chess.game.Player;
import com.chess.pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private Square[][] squares;
    private Player whitePlayer;
    private Player blackPlayer;

    public Board(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        squares = new Square[8][8];
        initializeBoard();
    }

    public List<Square> getAllSquares() {
        List<Square> allSquares = new ArrayList<>();
        for (Square[] row : squares) {
            for (Square square : row) {
                allSquares.add(square);
            }
        }
        return allSquares;
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j);
            }
        }

        initializePieces(0, true, whitePlayer);   // White
        initializePieces(7, false, blackPlayer);


        // Add pieces to players
        for (int i = 0; i < 8; i++) {
            squares[i][1].setPiece(new Pawn(true));
            squares[i][6].setPiece(new Pawn(false));
        }
    }

    private void initializePieces(int row, boolean isWhite, Player player) {
        Class<? extends Piece>[] pieces = new Class[]{
                Rook.class, Knight.class, Bishop.class, Queen.class,
                King.class, Bishop.class, Knight.class, Rook.class
        };

        for (int i = 0; i < 8; i++) {
            try {
                Piece piece = pieces[i].getConstructor(boolean.class).newInstance(isWhite);
                squares[i][row].setPiece(piece);
                player.getPieces().add(piece);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize piece", e);
            }
        }
    }

    public Square getSquare(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        return squares[x][y];
    }

    public void removePiece(Piece piece) {
        for (Square square : getAllSquares()) {
            if (square.getPiece() == piece) {
                square.clear();
                return;
            }
        }
    }

    public boolean isPathClear(Square start, Square end) {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        int dx = Integer.compare(x2, x1);
        int dy = Integer.compare(y2, y1);

        int steps = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

        for (int i = 1; i < steps; i++) {
            int x = x1 + dx * i;
            int y = y1 + dy * i;
            if (!squares[x][y].isEmpty()) {
                return false;
            }
        }

        return true;
    }
}

