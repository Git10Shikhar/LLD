package org.example;

import org.example.board.Board;
import org.example.board.BoardEntityFactory;
import org.example.board.Ladder;
import org.example.board.Snake;
import org.example.dice.DiceStrategy;
import org.example.dice.DoubleDiceStrategy;
import org.example.dice.SingleDiceStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DiceStrategy diceStrategy = new SingleDiceStrategy(1,6);

        List<Ladder> laddersList = Arrays.asList(

                BoardEntityFactory.createLadder(5, 8),
                BoardEntityFactory.createLadder(11, 26),
                BoardEntityFactory.createLadder(16, 22),
                BoardEntityFactory.createLadder(17, 70),
                BoardEntityFactory.createLadder(46, 88),
                BoardEntityFactory.createLadder(60, 85)
        );

        List<Snake> snakesList = Arrays.asList(

                BoardEntityFactory.createSnake(14, 7),
                BoardEntityFactory.createSnake(25, 2),
                BoardEntityFactory.createSnake(31, 26),
                BoardEntityFactory.createSnake(38, 20),
                BoardEntityFactory.createSnake(52, 42),
                BoardEntityFactory.createSnake(70, 55),
                BoardEntityFactory.createSnake(85, 72)
        );


        Board board = new Board(100, laddersList, snakesList);

        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        Game game = new Game(board, diceStrategy, players);

        game.play();

    }
}