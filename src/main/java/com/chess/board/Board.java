package com.chess.board;

import com.chess.game.Game;
import com.chess.game.Player;
import com.chess.pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final Square[][] squares;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private  Game game;

    public Board(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        squares = new Square[8][8];
        initializeBoard();
    }

    public List<Square> getAllSquares() {
        List<Square> allSquares = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Collections.addAll(allSquares, squares[i]);
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

        if (x1 == x2) {
            int step = Integer.compare(y2, y1);
            for (int y = y1 + step; y != y2; y += step) {
                if (!squares[x1][y].isEmpty()) return false;
            }
        }

        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 || x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
            return false;
        }

        int dx = Integer.compare(x2, x1);
        int dy = Integer.compare(y2, y1);

        int steps = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

        for (int i = 1; i < steps; i++) {
            int x = x1 + dx * i;
            int y = y1 + dy * i;
            if (x < 0 || x > 7 || y < 0 || y > 7 || !squares[x][y].isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public boolean isInCheck(Player player) {
        Square kingSquare = findKingSquare(player);
        Player opponent = player.isWhite() ? blackPlayer : whitePlayer;

        for (Piece piece : opponent.getPieces()) {
            Square pieceSquare = findPieceSquare(piece);
            if (pieceSquare != null && piece.isValidMove(this, pieceSquare, kingSquare)) {
                return true;
            }
        }
        return false;
    }

    public Square findKingSquare(Player player) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                Piece piece = square.getPiece();
                if (piece instanceof King && piece.isWhite() == player.isWhite()) {
                    return square;
                }
            }
        }
        throw new IllegalStateException("King not found!");
    }

    public Square findPieceSquare(Piece targetPiece) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.getPiece() == targetPiece) {
                    return square;
                }
            }
        }
        return null;
    }
}

