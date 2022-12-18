package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay2 {

    @Test
    public void testTestInput() {
        long expected = 15L;
        long actual = Day2.scoreMatches(Tokenizer.tokenizeMatches(Data.testInput));
        Assertions.assertEquals(expected, actual);
    }
}
