package org.grubentr.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay9 {
    @Test
    public void shouldBe13() {
        Assertions.assertEquals(13, Day9.part1(Data.testInput));
    }
}
