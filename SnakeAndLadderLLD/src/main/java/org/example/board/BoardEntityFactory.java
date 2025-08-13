package org.example.board;

public class BoardEntityFactory {

    public static Ladder createLadder(int start, int end){

        return new Ladder(start, end);
    }

    public static Snake createSnake(int start, int end){

        return new Snake(start, end);
    }
}
