package org.grubentr.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.grubentr.day1.Data.testInput;

public class TestTokenizer {
    @Test
    public void testTokenizer() {
        List<List<Integer>> expected = List.of(
                List.of(1000, 2000, 3000),
                List.of(4000),
                List.of(5000, 6000),
                List.of(7000, 8000, 9000),
                List.of(10000)
        );

        Assertions.assertEquals(expected, Tokenizer.tokenizeCalories(testInput));
    }

}
