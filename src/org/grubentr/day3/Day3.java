package org.grubentr.day3;


public class Day3 {

    public static void main(String[] args) {
        long part1 = Data.input
                .lines()
                .map(Rucksack::new)
                .map(Rucksack::getOverlap)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .map(Priority::getPriority)
                .reduce(Long::sum)
                .orElse(0L);
        System.out.println(part1);
    }
}
