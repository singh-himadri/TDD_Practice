package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    @DisplayName("Initialize a grid with all dead cells and confirm its dimensions and state ")
    public void initializeGridTest() {
//        int rows = 5;
//        int cols = 5;
//        boolean[][] grid = new boolean[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                assertTrue(!grid[i][j], "Cell at (" + i + "," + j + ") should be dead.");
//            }
//        }
        Grid grid = new Grid(5, 5);

        assertEquals(5, grid.getRows());
        assertEquals(5, grid.getCols());

        for(int row=0; row<grid.getRows(); row++){
            for(int col=0;col<grid.getCols();col++){
                assertFalse(grid.getCellSate(row, col));
            }
        }
    }

    @Test
    @DisplayName("Should set and retrieve the state of a specific cell in a grid")
    public void testSetGridStatus() {
//        int rows = 5;
//        int cols = 5;
//
//        boolean[][] grid = new boolean[rows][cols];
//
//        int row = 2;
//        int col = 3;
//
//        grid[row][col] = true;
//
//        boolean cellState = grid[row][col];
//        assertEquals(true, cellState, "Cell at (" + row + "," + col + ") should be alive.");
        //Improved Code way
        Grid grid = new Grid(5,5);
        grid.setCellState(3,4, true);
        assertTrue(grid.getCellSate(3, 4));
    }

    @DisplayName("Should set and retrieve the state of a specific cell in the grid")
    @ParameterizedTest(name="Should set and retrieve the state of a specific cell in the grid")
    @CsvSource(
            {
                    "5, 5",
                    "0, 0",
            }
    )
    public void testSetGridCellState(int row, int col){
        Grid grid = new Grid(5,5);
        grid.setCellState(row,col, true);
        assertTrue(grid.getCellSate(row, col));
    }

    @DisplayName("Should check if the given cell is within the grid")
    @Test
    public void testIsCellWithinGrid() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.isCellWithinGrid(0, 0));
        assertTrue(grid.isCellWithinGrid(4, 4));
        assertFalse(grid.isCellWithinGrid(5, 5));
        assertFalse(grid.isCellWithinGrid(-1, 0));
        assertFalse(grid.isCellWithinGrid(0, -1));
    }
    @DisplayName("Should check if the given cell is outside the grid")
    @Test
    public void testIsCellOutsideGrid(){
        Grid grid = new Grid(5,5);
        assertFalse(grid.isCellWithinGrid(5, 5));
        assertFalse(grid.isCellWithinGrid(-1, 0));
        assertFalse(grid.isCellWithinGrid(0, -1));
        assertFalse(grid.isCellWithinGrid(6, 4));
        assertFalse(grid.isCellWithinGrid(4, 6));
    }
}
