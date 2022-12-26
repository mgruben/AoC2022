package org.grubentr.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCharacterWindow {

    private void testHelper(int expectedCharacterProcessed, String input) {
        int windowSize = 4;

        CharacterWindow sut = new CharacterWindow(input, windowSize);

        while (sut.canAdvance() && sut.getNumUnique() != windowSize) {
            sut.advance();
        }

        Assertions.assertEquals(expectedCharacterProcessed, sut.getNumCharactersProcessed());
    }
    @Test
    public void shouldBeSeven() {
        testHelper(7, Data.testInput1);
    }

    @Test
    public void shouldBeFive() {
        testHelper(5, Data.testInput2);
    }

    @Test
    public void shouldBeSix() {
        testHelper(6, Data.testInput3);
    }

    @Test
    public void shouldBeTen() {
        testHelper(10, Data.testInput4);
    }

    @Test
    public void shouldBeEleven() {
        testHelper(11, Data.testInput5);
    }
}
