package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestShape {
    @Test
    public void testBeats() {
        Assertions.assertTrue(Shape.Paper.beats(Shape.Rock));
        Assertions.assertTrue(Shape.Scissors.beats(Shape.Paper));
        Assertions.assertTrue(Shape.Rock.beats(Shape.Scissors));
    }
}
