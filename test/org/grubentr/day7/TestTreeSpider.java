package org.grubentr.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestTreeSpider {

    @Test
    public void shouldBeOne() {
        Dir root = new Dir();
        root.addFile("2", 2L);
        root.addDir("child");
        Dir child = root.getDir("child");
        child.addFile("f", 1L);

        root.calcSizes();

        long expected = 1L;
        long actual = TreeSpider.findDir(new ArrayList<>(), root, dir -> dir.size() < 2L).stream()
                .mapToLong(Dir::size)
                .sum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBe95437() {
        ShellReader sr = new ShellReader();
        Data.testInput.lines().forEach(sr::parse);

        Dir root = sr.getRoot();
        root.calcSizes();

        long actual = TreeSpider.findDir(new ArrayList<>(), root, dir -> dir.size() <= 100000L).stream()
                .mapToLong(Dir::size)
                .sum();

        long expected = 95437L;


        Assertions.assertEquals(expected, actual);
    }
}
