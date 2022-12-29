package org.grubentr.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDir {
    @Test
    public void shouldBeZero() {
        Dir sut = new Dir();

        Assertions.assertEquals(0L, sut.size());

        sut.calcSizes();

        Assertions.assertEquals(0L, sut.size());
    }

    @Test
    public void shouldBeSizeOfFiles() {
        Dir sut = new Dir();
        sut.addFile("a", 1L);
        sut.addFile("b", 2L);

        sut.calcSizes();

        Assertions.assertEquals(3L, sut.size());
    }

    @Test
    public void shouldCalculateSizeRecursively() {
        Dir sut = new Dir();
        sut.addFile("f", 100L);
        sut.addDir("child");
        Dir child = sut.getDir("child");
        child.addFile("f", 10L);
        child.addFile("g", 1L);

        sut.calcSizes();

        Assertions.assertEquals(111L, sut.size());
    }
}
