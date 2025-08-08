package main.java.org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player P1 = new Player("Alice", Symbol.X);
        Player P2 = new Player("Bob", Symbol.O);

        TicTacToe game = new TicTacToe(P1, P2, 3);

        Scanner scanner = new Scanner(System.in);
        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {

            game.printBoard();
            System.out.println("Enter row and column for " + game.getCurrentPlayer().getName() + "'s move.");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            game.makeMove(row, col);
        }

        game.printBoard();
        game.reset();
        scanner.close();
    }
}