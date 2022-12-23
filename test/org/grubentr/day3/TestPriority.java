package org.grubentr.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
