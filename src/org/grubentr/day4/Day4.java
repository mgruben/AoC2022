package org.grubentr.day4;

public class Day4 {

    public static long countFullyContains(String input) {
        return input.lines()
                .map(RangePair::fromString)
                .filter(RangePair::fullyOverlaps)
                .count();
    }

    public static void main(String[] args) {

    }
}
