package org.example.board;

public class Ladder extends BoardEntity {

    public Ladder(int start, int end){

        super(start,end);

        if(start>=end)
            throw new IllegalArgumentException("Ladder must go up : start < end !!");
    }
}
