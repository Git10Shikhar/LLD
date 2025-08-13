package org.example.board;

public class BoardEntity {

    protected final int start;
    protected final int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

}
