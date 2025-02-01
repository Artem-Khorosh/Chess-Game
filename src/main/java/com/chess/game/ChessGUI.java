package com.chess.game;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChessGUI extends Application {


    private Board board;
    private final GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        board = new Board(new Player(true), new Player(false));
        drawBoard();

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = board.getSquare(i, j);
                StackPane pane = createSquarePane(i, j, square);
                gridPane.add(pane, j, i);
            }
        }

    }

    private StackPane createSquarePane(int i, int j, Square square) {
        StackPane pane = new StackPane();
        pane.setPrefSize(75, 75);
        pane.setStyle("-fx-background-color: " + ((i + j) % 2 == 0 ? "#f0d9b5" : "#b58863"));

        if (!square.isEmpty()) {
            Label label = new Label(getPieceSymbol(square.getPiece()));
            label.setStyle("-fx-font-size: 40;");
            pane.getChildren().add(label);
        }
        return pane;
    }

    private String getPieceSymbol(Piece piece) {
        if (piece instanceof King) return piece.isWhite() ? "♔" : "♚";
        if (piece instanceof Queen) return piece.isWhite() ? "♕" : "♛";
        if (piece instanceof Rook) return piece.isWhite() ? "♖" : "♜";
        if (piece instanceof Bishop) return piece.isWhite() ? "♗" : "♝";
        if (piece instanceof Knight) return piece.isWhite() ? "♘" : "♞";
        if (piece instanceof Pawn) return piece.isWhite() ? "♙" : "♟";
        return "";
    }

    public static void main(String[] args) {
        launch(args);
    }

}
