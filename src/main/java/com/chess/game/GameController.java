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
                int x1, y1;
                do {
                System.out.print("Enter the starting coordinates (x y):");
                 x1 = scanner.nextInt();
                 y1 = scanner.nextInt();
                } while (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7);

                // Ввод конечных координат
                int x2, y2;
                do {
                System.out.print("Enter destination coordinates (x y): ");
                 x2 = scanner.nextInt();
                 y2 = scanner.nextInt();
                } while (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7);

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

