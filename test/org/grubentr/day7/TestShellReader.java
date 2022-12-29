package org.grubentr.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestShellReader {

    @Test
    public void shouldBe48381165() {
        ShellReader sr = new ShellReader();
        Data.testInput.lines().forEach(sr::parse);

        Dir root = sr.getRoot();
        root.calcSizes();

        Assertions.assertEquals(48381165L, root.size());
    }
}
