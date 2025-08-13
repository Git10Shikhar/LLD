package org.example.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final int size;

    Map<Integer, Ladder> ladders;
    Map<Integer, Snake> snakes;

    public Board(int size, List<Ladder> laddersList, List<Snake> snakesList) {

        this.size = size;
        this.ladders=new HashMap<>();
        this.snakes=new HashMap<>();

        if(!laddersList.isEmpty()){

            for(Ladder ladder: laddersList)
                ladders.put(ladder.getStart(), ladder);
        }

        if(!snakesList.isEmpty()){

            for(Snake snake: snakesList)
                snakes.put(snake.getStart(), snake);
        }
    }

    public int getSize() {
        return size;
    }

    public Ladder getLadderAt(int cellNum){
        return ladders.get(cellNum);
    }

    public Snake getSnakeAt(int cellNum){
        return snakes.get(cellNum);
    }
}
