package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPriority {

    @Test
    public void testLowerCase() {
        int i = 1;
        String lowercase = "abcdefghijklmnopqrstuvwxyz";

        for (Character c : lowercase.toCharArray()) {
            Assertions.assertEquals(i++, Priority.getPriority(c));
        }
    }

    @Test
    public void testUpperCase() {
        int i = 27;
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (Character c : uppercase.toCharArray()) {
            Assertions.assertEquals(i++, Priority.getPriority(c));
        }
    }

    @Test
    public void testTestInput() {
        List<String> input = List.of("p", "L", "P", "v", "t", "s");

        long actual = input.stream()
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .map(Priority::getPriority)
                .reduce(Long::sum)
                .orElse(0L);

        Assertions.assertEquals(157L, actual);
    }
}
