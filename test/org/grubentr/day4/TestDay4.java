package org.grubentr.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay4 {

    @Test
    public void fullOverlapShouldBeTwo() {
        Assertions.assertEquals(2L, Day4.countFullyContains(Data.testInput));
    }

    @Test
    public void anyOverlapShouldBeFour() {
        Assertions.assertEquals(4L, Day4.countAnyOverlap(Data.testInput));
    }

}
