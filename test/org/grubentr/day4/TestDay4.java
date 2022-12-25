package org.grubentr.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay4 {

    @Test
    public void ShouldBeTwo() {
        Assertions.assertEquals(2L, Day4.countFullyContains(Data.testInput));
    }
}
