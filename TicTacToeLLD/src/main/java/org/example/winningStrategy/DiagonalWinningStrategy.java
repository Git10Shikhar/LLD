package main.java.org.example.winningStrategy;

import main.java.org.example.Board;
import main.java.org.example.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWinner(Board board, Symbol symbol) {

        int sameCount = 0;

        int size = board.getSize();

        for (int i = 0; i < size; i++) {

            if (board.getSymbol(i, i) == symbol)
                sameCount++;
        }

        if (sameCount == size)
            return true;

        sameCount = 0;

        for (int i = 0; i < size; i++) {

            if (board.getSymbol(i, size - 1 - i) == symbol)
                sameCount++;
        }

        return sameCount == size;
    }
}
