package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTokenizer {
    @Test
    public void testTestInput() {
        List<Match> expectedMatches = List.of(
                new Match(Shape.Rock, Shape.Paper),
                new Match(Shape.Paper, Shape.Rock),
                new Match(Shape.Scissors, Shape.Scissors)
        );

        Assertions.assertEquals(expectedMatches, Tokenizer.tokenizeMatches(Data.testInput));
    }
}
