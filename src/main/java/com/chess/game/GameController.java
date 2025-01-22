package com.chess.game;

import com.chess.board.Square;
import com.chess.pieces.Piece;

import java.util.Scanner;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!game.isGameOver()) {
                System.out.println("Player move: " + (game.getCurrentPlayer().isWhite() ? "White" : "Black"));
                System.out.print("Enter the starting coordinates (x y):");
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                System.out.print("Enter destination coordinates (x y): ");
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();

                Square start = game.getBoard().getSquare(x1, y1);
                Square end = game.getBoard().getSquare(x2, y2);
                Piece piece = start.getPiece();

                if (piece != null && piece.isWhite() == game.getCurrentPlayer().isWhite()) {
                    piece.move(game.getBoard(), start, end);
                } else {
                    System.out.println("Illegal move!");
                }
            }
        }
    }

}

