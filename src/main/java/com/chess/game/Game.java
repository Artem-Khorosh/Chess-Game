package com.chess.game;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.King;
import com.chess.pieces.Piece;
import lombok.Getter;

import java.util.List;

@Getter
public class Game {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;

    public Game() {
        whitePlayer = new Player(true);
        blackPlayer = new Player(false);
        board = new Board( whitePlayer, blackPlayer);
        currentPlayer = whitePlayer;
    }

    public void play() {
        while (!isGameOver()) {
            // Switch players
            currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public boolean isGameOver() {
        return isCheckmate(currentPlayer) || isStalemate(currentPlayer);
    }
    private boolean isInCheck(Player player) {
        Square kingSquare = board.findKingSquare(player);
        List<Piece> opponentPieces = player.isWhite() ? blackPlayer.getPieces() : whitePlayer.getPieces();

        for (Piece piece : opponentPieces) {
            Square currentSquare = board.findPieceSquare(piece);
            if (piece.isValidMove(board, currentSquare, kingSquare)) {
                return true;
            }
        }
        return false;
    }



    private boolean isCheckmate(Player player) {
        if (!isInCheck(player))
            return false;
        return hasNoLegalMoves(player);
    }
    private boolean isStalemate(Player player) {
        if (isInCheck(player)) return false;
        return hasNoLegalMoves(player);
    }

    private boolean hasNoLegalMoves(Player player) {
        for (Piece piece : player.getPieces()) {
            Square currentSquare = board.findPieceSquare(piece);
            for (Square square : board.getAllSquares()) {
                if (piece.isValidMove(board, currentSquare, square)) {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Game game = new Game();
        GameController controller = new GameController(game);
        controller.start();
    }


}
