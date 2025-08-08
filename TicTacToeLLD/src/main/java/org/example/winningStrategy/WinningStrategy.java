package main.java.org.example.winningStrategy;

import main.java.org.example.Board;
import main.java.org.example.Symbol;

public interface WinningStrategy {

    boolean checkIfWinner(Board board, Symbol symbol);
}
