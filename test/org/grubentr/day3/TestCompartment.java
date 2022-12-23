package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCompartment {
    @Test
    public void shouldAllBeOne() {
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Compartment sut = new Compartment(input);

        for (Character c : input.toCharArray()) {
            Assertions.assertEquals(1, sut.numberOf(c));
        }
    }

    @Test
    public void aShouldBe3() {
        Compartment sut = new Compartment("aaa");

        Assertions.assertEquals(3, sut.numberOf('a'));
    }

    @Test
    public void shouldNotOverlap() {
        Compartment left = new Compartment("abc");
        Compartment right = new Compartment("ABC");

        Assertions.assertEquals("", left.getOverlap(right));
    }

    @Test
    public void shouldFullyOverlap() {
        Compartment left = new Compartment("ABB");
        Compartment right = new Compartment("AAB");

        Assertions.assertEquals("AB", left.getOverlap(right));
    }

    @Test
    public void shouldPartiallyOverlap() {
        Compartment left = new Compartment("abcd");
        Compartment right = new Compartment("xbyz");

        Assertions.assertEquals("b", right.getOverlap(left));
    }
}
