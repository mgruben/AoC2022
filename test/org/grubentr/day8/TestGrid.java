package org.grubentr.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGrid {
    private Grid grid;

    @BeforeEach
    public void setup() {
        grid = new Grid(new int[][]{
                {3,0,3,7,3},
                {2,5,5,1,2},
                {6,5,3,3,2},
                {3,3,5,4,9},
                {3,5,3,9,0}
        });
    }

    @Test
    public void testGrid() {
        Assertions.assertEquals(21, grid.getNumVisible());
    }
}
