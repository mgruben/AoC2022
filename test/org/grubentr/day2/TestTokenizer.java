package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTokenizer {
    @Test
    public void testTestInputPart1() {
        List<Match> expectedMatches = List.of(
                new Match(Shape.Rock, Shape.Paper),
                new Match(Shape.Paper, Shape.Rock),
                new Match(Shape.Scissors, Shape.Scissors)
        );

        Assertions.assertEquals(expectedMatches, Tokenizer.tokenizePart1(Data.testInput));
    }

    @Test
    public void testTestInputPart2() {
        List<Match> expectedMatches = List.of(
                new Match(Shape.Rock, Shape.Rock),
                new Match(Shape.Paper, Shape.Rock),
                new Match(Shape.Scissors, Shape.Rock)
        );

        Assertions.assertEquals(expectedMatches, Tokenizer.tokenizePart2(Data.testInput));
    }
}
