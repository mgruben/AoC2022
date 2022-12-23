package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestRucksack {

    @Test
    public void testTestInput() {
        List<String> expected = List.of("p", "L", "P", "v", "t", "s");

        List<String> actual = Data.testInput.lines()
                .map(Rucksack::new)
                .map(Rucksack::getOverlap)
                .toList();

        Assertions.assertEquals(expected, actual);
    }
}
