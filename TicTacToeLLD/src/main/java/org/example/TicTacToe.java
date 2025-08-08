package main.java.org.example;

import main.java.org.example.winningStrategy.ColumnWinningStrategy;
import main.java.org.example.winningStrategy.DiagonalWinningStrategy;
import main.java.org.example.winningStrategy.RowWinningStrategy;
import main.java.org.example.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private final Board board;
    private final Player[] players;
    private GameStatus gameStatus;
    private int currentPlayerIndex;


    public TicTacToe(Player player1, Player player2, int size) {

        List<WinningStrategy> strategies = new ArrayList<>();
        strategies.add(new RowWinningStrategy());
        strategies.add(new ColumnWinningStrategy());
        strategies.add(new DiagonalWinningStrategy());

        this.board = new Board(size, strategies);
        this.players = new Player[]{player1, player2};
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }

    public synchronized void makeMove(int row, int col) {

        if (!board.isValid(row, col) || gameStatus != GameStatus.IN_PROGRESS)
            return;

        Player currentPlayer = players[currentPlayerIndex];
        board.placeMove(row, col, currentPlayer.getSymbol());

        if (board.checkWin(currentPlayer.getSymbol())) {

            System.out.println("Winner is - " + currentPlayer.getName() + ", Congratulations \uD83D\uDC4B");
            gameStatus = GameStatus.WIN;
            return; // game complete

        } else if (board.isFull()) {

            System.out.println(" Game is a draw \uD83D\uDE00");
            gameStatus = GameStatus.DRAW;
            return; // game complete
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public Player getCurrentPlayer() {

        return players[currentPlayerIndex];
    }

    public void reset() {

        board.reset();
        gameStatus = GameStatus.IN_PROGRESS;
        currentPlayerIndex = 0;
    }

    public GameStatus getGameStatus() {

        return gameStatus;
    }

    public void printBoard() {

        board.printBoard();
    }


}
