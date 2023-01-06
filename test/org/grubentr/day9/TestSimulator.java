package org.grubentr.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.grubentr.day9.Coord.*;

public class TestSimulator {
    private static final Coord ZERO = new Coord(0, 0);
    private Simulator sut;

    @BeforeEach
    public void setup() {
        sut = new Simulator(2);
    }

    @Test
    public void shouldHaveThreeAlongRight() {
        Set<Coord> expected = new HashSet<>();
        expected.add(ZERO);

        Assertions.assertEquals(expected, sut.getVisited());

        sut.update(RIGHT);
        Assertions.assertEquals(expected, sut.getVisited());

        sut.update(RIGHT);
        expected.add(new Coord(1, 0));
        Assertions.assertEquals(expected, sut.getVisited());

        sut.update(RIGHT);
        expected.add(new Coord(2, 0));
        Assertions.assertEquals(expected, sut.getVisited());

        sut.update(RIGHT);
        expected.add(new Coord(3, 0));
        Assertions.assertEquals(expected, sut.getVisited());
    }

    @Test
    public void shouldHandleDiagonals() {
        Set<Coord> expected = new HashSet<>();
        expected.add(ZERO);

        sut.update(RIGHT);
        sut.update(UP);
        sut.update(UP);
        expected.add(new Coord(1, 1));
        sut.update(RIGHT);

        Assertions.assertEquals(expected, sut.getVisited());
    }

    @Test
    public void backAndForthShouldNotUpdateVisited() {
        Set<Coord> expected = new HashSet<>();
        expected.add(ZERO);

        Assertions.assertEquals(expected, sut.getVisited());
        sut.update(RIGHT);
        sut.update(UP);
        sut.update(LEFT);
        sut.update(LEFT);
        sut.update(DOWN);
        sut.update(DOWN);
        sut.update(RIGHT);
        sut.update(RIGHT);
        Assertions.assertEquals(expected, sut.getVisited());
    }
}
