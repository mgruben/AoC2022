package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGroup {
    @Test
    public void shouldBe_r() {
        Group sut = new Group("vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg");

        Assertions.assertEquals('r', sut.getBadge());
    }

    @Test
    public void shouldBeZ() {
        Group sut = new Group("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw");

        Assertions.assertEquals('Z', sut.getBadge());
    }
}
