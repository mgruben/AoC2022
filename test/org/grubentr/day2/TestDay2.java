package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay2 {

    private static void testHelper(long expected, String input) {
        long actual = Day2.scoreMatches(Tokenizer.tokenizeMatches(input));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTestInput() {
        testHelper(15L, Data.testInput);
    }

    @Test
    public void testPart1(){
        testHelper(14531L, Data.part1);
    }
}
