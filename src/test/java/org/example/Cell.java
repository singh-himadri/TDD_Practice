package org.example;

public class Cell {
    private boolean alive;

    Cell(boolean alive) {
        this.alive= alive;
    }

    public void update(int liveNeighbours) {
        if (liveNeighbours == 1) {
            this.alive = false;
        } else if(liveNeighbours <= 3) {
            this.alive = true;
        }
    }

    public boolean isalive() {
        return this.alive;
    }

}
