package main.java.org.example.winningStrategy;

import main.java.org.example.Board;
import main.java.org.example.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWinner(Board board, Symbol symbol) {

        int size = board.getSize();

        for (int col = 0; col < size; col++) {

            int sameCount = 0;
            for (int row = 0; row < size; row++) {

                if (board.getSymbol(row, col) == symbol)
                    sameCount++;
            }

            if (sameCount == size)
                return true;
        }

        return false;
    }
}
