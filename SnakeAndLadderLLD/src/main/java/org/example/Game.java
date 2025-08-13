package org.example;

import org.example.board.Board;
import org.example.board.Ladder;
import org.example.board.Snake;
import org.example.dice.DiceStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private final Board board;
    private final DiceStrategy diceStrategy;
    private final Queue<Player> playersQueue;
    private GameStatus gameStatus;
    private Player winner;

    public Game(Board board, DiceStrategy diceStrategy, List<Player> players) {

        if (diceStrategy == null) throw new IllegalArgumentException("DiceStrategy required");
        if (board == null) throw new IllegalArgumentException("Board required");
        if (players == null || players.size() < 2) throw new IllegalArgumentException("At least two players required");

        this.board = board;
        this.diceStrategy = diceStrategy;
        this.playersQueue = new LinkedList<>(players);
        this.gameStatus = GameStatus.NOT_STARTED;
        this.winner = null;
    }

    public void play() {

        gameStatus = GameStatus.IN_PROGRESS;
        System.out.println(" Starting game with board size - " + board.getSize());

        while (gameStatus == GameStatus.IN_PROGRESS) {

            Player currPlayer = playersQueue.poll();
            takeTurn(currPlayer);

            if (winner != null) {

                gameStatus = GameStatus.FINISHED;
                System.out.println(" Game finished. WINNER IS - " + currPlayer.getName());
            } else {
                playersQueue.offer(currPlayer);
            }
        }
    }

    public void takeTurn(Player player) {

        System.out.println("Next move - " + player.getName() + "'s chance. ");

        int startPos = player.getPosition();
        int roll = diceStrategy.roll();
        int nextPos = startPos + roll;

        System.out.println(player.getName() + " rolled " + roll + " (from " + startPos + " )");

        if (nextPos > board.getSize()) {

            System.out.println(" -> overshoots the last cell. Stays at " + startPos + " )");
            return;
        }

        Ladder ladder = board.getLadderAt(nextPos);
        if (ladder != null) {

            System.out.println(" Ladder at cell! Climbing up from " + ladder.getStart() + " to " + ladder.getEnd());
            nextPos = ladder.getEnd();

        } else {

            Snake snake = board.getSnakeAt(nextPos);
            if (snake != null) {

                System.out.println(" Snake at cell! Sliding down from " + snake.getStart() + " to " + snake.getEnd());
                nextPos = snake.getEnd();
            }
        }

        player.setPosition(nextPos);

        if (nextPos == board.getSize())
            winner = player;
    }

}
