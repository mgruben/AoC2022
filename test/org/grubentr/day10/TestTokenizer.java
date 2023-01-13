package org.grubentr.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTokenizer {
    @Test
    public void shouldParseThings() {
        List<Instruction> expected = List.of(
                new Noop(),
                new Addx(3),
                new Addx(-5)
        );

        List<Instruction> actual = Data.tinyInput.lines()
                .map(Tokenizer::toInstruction)
                .toList();

        Assertions.assertIterableEquals(expected, actual);
    }
}
