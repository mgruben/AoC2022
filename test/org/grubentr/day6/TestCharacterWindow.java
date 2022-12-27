package org.grubentr.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCharacterWindow {

    private void testHelper(int expectedCharacterProcessed, String input, int windowSize) {
        CharacterWindow sut = new CharacterWindow(input, windowSize);

        while (sut.canAdvance() && sut.getNumUnique() != windowSize) {
            sut.advance();
        }

        Assertions.assertEquals(expectedCharacterProcessed, sut.getNumCharactersProcessed());
    }

    private void part1TestHelper(int expectedCharacterProcessed, String input) {
        testHelper(expectedCharacterProcessed, input, 4);
    }

    private void part2TestHelper(int expectedCharacterProcessed, String input) {
        testHelper(expectedCharacterProcessed, input, 14);
    }

    @Test
    public void shouldBeSeven() {
        part1TestHelper(7, Data.testInput1);
    }

    @Test
    public void shouldBeFive() {
        part1TestHelper(5, Data.testInput2);
    }

    @Test
    public void shouldBeSix() {
        part1TestHelper(6, Data.testInput3);
    }

    @Test
    public void shouldBeTen() {
        part1TestHelper(10, Data.testInput4);
    }

    @Test
    public void shouldBeEleven() {
        part1TestHelper(11, Data.testInput5);
    }
}
