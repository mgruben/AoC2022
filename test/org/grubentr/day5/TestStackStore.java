package org.grubentr.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStackStore {
    @Test
    public void shouldBeThreeSpaces() {
        StackStore sut = new StackStore(3);

        Assertions.assertEquals("   ", sut.peekTops());
    }

    @Test
    public void shouldAddAToSecondCrate() {
        // Given
        StackStore sut = new StackStore(3);
        sut.addCrates("    [A]    ");

        Assertions.assertEquals(" A ", sut.peekTops());
    }

    @Test
    public void shouldBeNDP() {
        // Given
        StackStore sut = new StackStore(3);
        sut.addCrates("[Z] [M] [P]");
        sut.addCrates("[N] [C]    ");
        sut.addCrates("    [D]    ");

        Assertions.assertEquals("NDP", sut.peekTops());
    }

    @Test
    public void shouldBeCMZ() {
        StackStore sut = Tokenizer.fromInputPart1(Data.testInput);

        Assertions.assertEquals("CMZ", sut.peekTops());
    }
}
