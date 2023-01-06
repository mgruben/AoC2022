package org.grubentr.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay9 {
    @Test
    public void shouldBe13() {
        Assertions.assertEquals(13, Day9.part1(Data.testInput));
    }

    @Test
    public void shouldBe1() {
        Assertions.assertEquals(1, Day9.part2(Data.testInput));
    }
}
