package main.java.org.example;

public class Cell {

    Symbol symbol;

    public Cell() {

        this.symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {

        return symbol;
    }

    public void setSymbol(Symbol symbol) {

        this.symbol = symbol;
    }

    public boolean isEmpty() {

        return symbol == Symbol.EMPTY;
    }
}
