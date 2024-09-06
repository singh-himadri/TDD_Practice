package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConway {
    @DisplayName("A live cell with fewer than two live cells neighbour")
    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighbourShouldDie(){
        int liveNeighbours = 1;
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertFalse(cell.isalive());
    }

    @DisplayName("A live cell with two or three live neighbors survives (survival)")
    @ParameterizedTest(name = "A Live Cell With {0} Live Neighbours Survives")
    @ValueSource(ints = {2,3})
    public void testLiveCellWithTwoOrThreeLiveNeighboursSurvives(int liveNeighbours){
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertTrue(cell.isalive());
    }

    @DisplayName("A live cell with more than three live cell dies")
    @ParameterizedTest(name = "A live cell with more than three live cell dies")
    @ValueSource(ints = {4,5,6,7,8})
    public void aLiveCellWithMoreThanThreeLiveCellDies(int liveNeighbours){
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertTrue(cell.isalive());
    }

    @DisplayName("A live cell with fewer than two live neighbour dies")
    @Test
    public void aLiveCellWithFewerThanTwoLiveNeighbourDies(){
        int liveNeighbours = 4;
        Cell cell = new Cell(false);
        cell.update(liveNeighbours);
        assertFalse(cell.isalive());
    }


}
