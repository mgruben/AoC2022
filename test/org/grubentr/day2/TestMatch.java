package org.grubentr.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMatch {

    static void matchScoreHelper(int expectedScore, Shape opponent, Shape you) {
        Assertions.assertEquals(expectedScore,
                new Match(opponent, you).score());
    }
    @Test
    public void testMatches() {
        matchScoreHelper(8, Shape.Rock, Shape.Paper);
        matchScoreHelper(1, Shape.Paper, Shape.Rock);
        matchScoreHelper(6, Shape.Scissors, Shape.Scissors);
    }
}
