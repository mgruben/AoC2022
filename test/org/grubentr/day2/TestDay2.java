package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay2 {

    private static void testHelperPart2(long expected, String input) {
        long actual = Day2.scoreMatches(Tokenizer.tokenizePart2(input));
        Assertions.assertEquals(expected, actual);
    }

    private static void testHelperPart1(long expected, String input) {
        long actual = Day2.scoreMatches(Tokenizer.tokenizePart1(input));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTestInput() {
        testHelperPart1(15L, Data.testInput);
        testHelperPart2(12L, Data.testInput);
    }

    @Test
    public void testPart1(){
        testHelperPart1(14531L, Data.input);
    }
}
