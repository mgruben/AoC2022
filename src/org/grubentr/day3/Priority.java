package org.grubentr.day3;

public class Priority {
    public static long getPriority(char c) {
        if (c <= 'Z') return c - 'A' + 27;
        else return c - 'a' + 1;
    }
}
