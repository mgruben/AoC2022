package org.grubentr.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCoord {
    private static final Coord LEFT = new Coord(-1, 0);
    private static final Coord RIGHT = new Coord(1, 0);
    private static final Coord UP = new Coord(0, 1);
    private static final Coord DOWN = new Coord(0, -1);
    private static final Coord ZERO = new Coord(0, 0);
    @Test
    public void addingZeroShouldBeTheSameCoordinate() {
        Assertions.assertEquals(LEFT, ZERO.plus(LEFT));
        Assertions.assertEquals(LEFT, LEFT.plus(ZERO));

        Assertions.assertEquals(RIGHT, ZERO.plus(RIGHT));
        Assertions.assertEquals(RIGHT, RIGHT.plus(ZERO));

        Assertions.assertEquals(UP, ZERO.plus(UP));
        Assertions.assertEquals(UP, UP.plus(ZERO));

        Assertions.assertEquals(DOWN, ZERO.plus(DOWN));
        Assertions.assertEquals(DOWN, DOWN.plus(ZERO));
    }

    @Test
    public void diffingTheSameCoordinateShouldBeZero() {
        Assertions.assertEquals(ZERO, LEFT.diff(LEFT));
        Assertions.assertEquals(ZERO, RIGHT.diff(RIGHT));
        Assertions.assertEquals(ZERO, UP.diff(UP));
        Assertions.assertEquals(ZERO, DOWN.diff(DOWN));

    }
}
