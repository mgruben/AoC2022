package org.grubentr.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.grubentr.day1.Data.input;
import static org.grubentr.day1.Data.testInput;


public class TestDay1 {
    @Test
    public void estTestInput() {
        Assertions.assertEquals(Optional.of(24000), Day1.getTopElf(testInput));
        Assertions.assertEquals(45000, Day1.getTopThreeElves(testInput).stream().reduce(0, Integer::sum));
    }

    @Test
    public void testInput() {
        Assertions.assertEquals(Optional.of(72070), Day1.getTopElf(input));
        Assertions.assertEquals(211805, Day1.getTopThreeElves(input).stream().reduce(0, Integer::sum));
    }
}
