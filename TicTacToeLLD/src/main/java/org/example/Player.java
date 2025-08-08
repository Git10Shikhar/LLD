package main.java.org.example;

public class Player {

    final String playerName;
    final Symbol symbol;

    public Player(String playerName, Symbol symbol) {

        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getName() {

        return playerName;
    }

    public Symbol getSymbol() {

        return symbol;
    }
}
