package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTokenizer {

    @Test
    public void testTestInput() {
        List<List<String>> actual = Tokenizer.toGroups(Data.testInput);

        Assertions.assertEquals(2, actual.size());
        for (List<String> group : actual) {
            Assertions.assertEquals(3, group.size());
        }
    }
}
