package main.java.org.example;

import main.java.org.example.winningStrategy.WinningStrategy;

import java.util.List;

public class Board {

    private final int size;
    private final Cell[][] grid;
    private final List<WinningStrategy> winningStrategies;
    private int movesCount = 0;

    public Board(int size, List<WinningStrategy> winningStrategies) {

        this.size = size;
        this.grid = new Cell[size][size];
        this.winningStrategies = winningStrategies;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                grid[i][j] = new Cell();
            }
        }
    }

    public int getSize() {

        return size;
    }

    public boolean isValid(int row, int col) {

        return row >= 0 && row < size && col >= 0 && col < size && (grid[row][col].getSymbol() == Symbol.EMPTY);
    }

    public void placeMove(int row, int col, Symbol symbol) {

        grid[row][col].setSymbol(symbol);
        movesCount++;
    }

    public boolean checkWin(Symbol symbol) {

        for (WinningStrategy winningStrategy : winningStrategies) {

            if (winningStrategy.checkIfWinner(this, symbol))
                return true;
        }

        return false;
    }

    public boolean isFull() {

        return movesCount == size * size;
    }

    public Symbol getSymbol(int rwo, int col) {

        return grid[rwo][col].getSymbol();
    }

    public void reset() {

        movesCount = 0;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                grid[i][j].setSymbol(Symbol.EMPTY);
            }
        }
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                Symbol s = grid[i][j].getSymbol();
                System.out.print((s == Symbol.EMPTY ? "-" : s) + " ");
            }

            System.out.println();
        }
    }
}
