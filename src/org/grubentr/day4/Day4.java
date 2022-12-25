package org.grubentr.day4;

public class Day4 {

    public static long countFullyContains(String input) {
        return input.lines()
                .map(RangePair::fromString)
                .filter(RangePair::fullyOverlaps)
                .count();
    }

    public static long countAnyOverlap(String input) {
        return input.lines()
                .map(RangePair::fromString)
                .filter(RangePair::overlapsAny)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(Day4.countFullyContains(Data.input));
        System.out.println(Day4.countAnyOverlap(Data.input));
    }
}
